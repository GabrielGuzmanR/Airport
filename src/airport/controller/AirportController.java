package airport.controller;

import airport.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AirportController {
    private final Plane_Controller planeController;
    private final Flight_Controller flightController;
    private final Location_Controller locationController;
    private final Passenger_Controller passengerController;

    public AirportController(
        Plane_Controller planeController,
        Flight_Controller flightController,
        Location_Controller locationController,
        Passenger_Controller passengerController
    ) {
        this.planeController = planeController;
        this.flightController = flightController;
        this.locationController = locationController;
        this.passengerController = passengerController;
    }

    // Métodos públicos para delegar a los controladores individuales
    public void registerPassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        Passenger newPassenger = new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country);
        passengerController.createPassenger(newPassenger);
    }

    public void createPlane(String id, String brand, String model, int maxCapacity, String airline) {
        Plane newPlane = new Plane(id, brand, model, maxCapacity, airline);
        planeController.createPlane(newPlane);
    }

    public void createLocation(String id, String name, String city, String country, double latitude, double longitude) {
        Location newLocation = new Location(id, name, city, country, latitude, longitude);
        locationController.createLocation(newLocation);
    }

    public void createFlight(
        String id,
        String planeId,
        String departureLocationId,
        String arrivalLocationId,
        String scaleLocationId,
        int year,
        int month,
        int day,
        int hour,
        int minutes,
        int hoursDurationsArrival,
        int minutesDurationsArrival,
        int hoursDurationsScale,
        int minutesDurationsScale
    ) {
        Plane plane = planeController.getPlane(planeId);
        Location departure = locationController.getLocation(departureLocationId);
        Location arrival = locationController.getLocation(arrivalLocationId);
        Location scale = (scaleLocationId != null) ? locationController.getLocation(scaleLocationId) : null;

        LocalDateTime departureDate = LocalDateTime.of(year, month, day, hour, minutes);
        Flight newFlight = (scale == null)
            ? new Flight(id, plane, departure, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival)
            : new Flight(id, plane, departure, scale, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival, hoursDurationsScale, minutesDurationsScale);

        flightController.createFlight(newFlight);
    }

    public void addPassengerToFlight(long passengerId, String flightId) {
        Passenger passenger = passengerController.getPassenger(passengerId);
        Flight flight = flightController.getFlight(flightId);

        flight.addPassenger(passenger);
        passenger.addFlight(flight);

        // Actualizamos las entidades en sus respectivos storages
        flightController.updateFlight(flight);
        passengerController.updatePassenger(passenger);
    }

    public void delayFlight(String flightId, int hours, int minutes) {
        Flight flight = flightController.getFlight(flightId);
        flight.delay(hours, minutes);
        flightController.updateFlight(flight);
    }

    public List<Location> getAllLocations() {
        return locationController.getAllLocations();
    }

    public List<Plane> getAllPlanes() {
        return planeController.getAllPlanes();
    }

    public List<Flight> getAllFlights() {
        return flightController.getAllFlights();
    }

    public List<Passenger> getAllPassengers() {
        return passengerController.getAllPassengers();
    }
}