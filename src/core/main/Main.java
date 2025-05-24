/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.main;

import airport.controller.AirportController;
import airport.controller.Flight_Controller;
import airport.controller.Location_Controller;
import airport.controller.Passenger_Controller;
import airport.controller.Plane_Controller;
import airport.controller.interfaces.FlightControllerInterface;
import airport.controller.interfaces.LocationControllerInterface;
import airport.controller.interfaces.PassengerControllerInterface;
import airport.controller.interfaces.PlaneControllerInterface;
import airport.model.Flight;
import airport.model.Location;
import airport.model.Passenger;
import airport.model.Plane;
import airport.service.FlightService;
import airport.service.LocationService;
import airport.service.PassengerService;
import airport.service.PlaneService;
import airport.service.validator.impl.FlightValidator;
import airport.service.validator.impl.LocationValidator;
import airport.service.validator.impl.PassengerValidator;
import airport.service.validator.impl.PlaneValidator;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.impl.StorageFlightImpl;
import airport.storage.impl.StorageLocationImpl;
import airport.storage.impl.StoragePassengerImpl;
import airport.storage.impl.StoragePlaneImpl;
import airport.storage.interfaces.StorageFlight;
import airport.storage.interfaces.StorageLocation;
import airport.storage.interfaces.StoragePassenger;
import airport.storage.interfaces.StoragePlane;
import airport.utils.JsonLoader;
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
        List<Plane> planes = JsonLoader.loadPlanes("planes.json");
        List<Location> locations = JsonLoader.loadLocations("locations.json");
        List<Passenger> passengers = JsonLoader.loadPassengers("passengers.json");
        List<Flight> flights = JsonLoader.loadFlights("flights.json", planes, locations);

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

        AirportController controller = new AirportController(
            planeController,
            flightController,
            locationController,
            passengerController
        );

        java.awt.EventQueue.invokeLater(() -> {
            new AirportFrame(controller).setVisible(true);
        });
    }
}
