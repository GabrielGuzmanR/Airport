/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.main;

import airport.controller.impl.AirportController;
import airport.controller.impl.Flight_Controller;
import airport.controller.impl.Location_Controller;
import airport.controller.impl.Passenger_Controller;
import airport.controller.impl.Plane_Controller;
import airport.controller.interfaces.FlightControllerInterface;
import airport.controller.interfaces.LocationControllerInterface;
import airport.controller.interfaces.PassengerControllerInterface;
import airport.controller.interfaces.PlaneControllerInterface;
import airport.infrastructure.loader.JsonLoader;
import airport.infrastructure.loader.impl.FlightLoader;
import airport.infrastructure.loader.impl.LocationLoader;
import airport.infrastructure.loader.impl.PassengerLoader;
import airport.infrastructure.loader.impl.PlaneLoader;
import airport.infrastructure.storage.impl.StorageFlightImpl;
import airport.infrastructure.storage.impl.StorageLocationImpl;
import airport.infrastructure.storage.impl.StoragePassengerImpl;
import airport.infrastructure.storage.impl.StoragePlaneImpl;
import airport.infrastructure.storage.interfaces.StorageFlight;
import airport.infrastructure.storage.interfaces.StorageLocation;
import airport.infrastructure.storage.interfaces.StoragePassenger;
import airport.infrastructure.storage.interfaces.StoragePlane;
import airport.model.Flight;
import airport.model.Location;
import airport.model.Passenger;
import airport.model.Plane;
import airport.service.impl.AirportService;
import airport.service.impl.FlightService;
import airport.service.impl.LocationService;
import airport.service.impl.PassengerService;
import airport.service.impl.PlaneService;
import airport.service.validator.impl.FlightValidator;
import airport.service.validator.impl.LocationValidator;
import airport.service.validator.impl.PassengerValidator;
import airport.service.validator.impl.PlaneValidator;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.view.AirportFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.List;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {

        System.setProperty("flatlaf.useNativeLibrary", "false");
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // 1. Carga modelos
        List<Plane> planes = JsonLoader.loadModel("planes.json", new PlaneLoader());
        List<Location> locations = JsonLoader.loadModel("locations.json", new LocationLoader());
        List<Passenger> passengers = JsonLoader.loadModel("passengers.json", new PassengerLoader());
        List<Flight> flights = JsonLoader.loadModel("flights.json", new FlightLoader(planes, locations));

        // 2. Storages
        StorageLocation locationStorage = new StorageLocationImpl(locations);
        StorageFlight flightStorage = new StorageFlightImpl(flights);
        StoragePlane planeStorage = new StoragePlaneImpl(planes);
        StoragePassenger passengerStorage = new StoragePassengerImpl(passengers);

        // 3. Validadores
        ValidatorInterface<Location> locationValidator = new LocationValidator();
        ValidatorInterface<Flight> flightValidator = new FlightValidator();
        ValidatorInterface<Plane> planeValidator = new PlaneValidator();
        ValidatorInterface<Passenger> passengerValidator = new PassengerValidator();

        // 4. Servicios
        LocationService locationService = new LocationService(locationStorage, locationValidator);
        FlightService flightService = new FlightService(flightStorage, flightValidator);
        PlaneService planeService = new PlaneService(planeStorage, planeValidator);
        PassengerService passengerService = new PassengerService(passengerStorage, passengerValidator);

        // 5. Controladores
        LocationControllerInterface locationController = new Location_Controller(locationService);
        FlightControllerInterface flightController = new Flight_Controller(flightService);
        PlaneControllerInterface planeController = new Plane_Controller(planeService);
        PassengerControllerInterface passengerController = new Passenger_Controller(passengerService);

        /** Se inyectan los controladores al servicio orquestadors **/
        AirportService airportService = new AirportService(planeController,
                flightController,
                locationController,
                passengerController);

        /** Se inyecta el servicio al controlador principal **/
        AirportController controller = new AirportController(airportService);

        java.awt.EventQueue.invokeLater(() -> {
            new AirportFrame(controller).setVisible(true);
        });
    }
}
