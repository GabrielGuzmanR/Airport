package airport.utils;

import airport.model.*;
import airport.service.loader.impl.FlightLoader;
import airport.service.loader.impl.LocationLoader;
import airport.service.loader.impl.PassengerLoader;
import airport.service.loader.impl.PlaneLoader;

import java.util.*;

public class JsonLoader {

    public static List<Plane> loadPlanes(String filePath) {
        try {
            PlaneLoader loader = new PlaneLoader();
            return loader.load(filePath);
        } catch (Exception e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Location> loadLocations(String filePath) {
        try {
            LocationLoader loader = new LocationLoader();
            return loader.load(filePath);
        } catch (Exception e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Passenger> loadPassengers(String filePath) {

        try {
            PassengerLoader loader = new PassengerLoader();
            return loader.load(filePath);
        } catch (Exception e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Para Flight necesitas pasar las listas de planes y locations ya cargadas
    public static List<Flight> loadFlights(String filePath, List<Plane> planes, List<Location> locations) {

        try {
            FlightLoader loader = new FlightLoader();
            return loader.load(filePath, planes, locations);
        } catch (Exception e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}