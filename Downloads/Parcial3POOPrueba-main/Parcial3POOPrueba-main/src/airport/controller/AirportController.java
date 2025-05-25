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

    // --------- CREAR ENTIDADES ----------
    public void registerPassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        Passenger passenger = new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country);
        passengerController.createPassenger(passenger);
    }

    public void createPlane(String id, String brand, String model, int maxCapacity, String airline) {
        planeController.createPlane(id, brand, model, maxCapacity, airline);
    }

    public void createLocation(String id, String name, String city, String country, double latitude, double longitude) {
        locationController.createLocation(id, name, city, country, latitude, longitude);
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
        Location scale = (scaleLocationId != null && !scaleLocationId.isEmpty() && !scaleLocationId.equals("-")) ? locationController.getLocation(scaleLocationId) : null;

        LocalDateTime departureDate = LocalDateTime.of(year, month, day, hour, minutes);

        Flight flight;
        if (scale == null) {
            flight = new Flight(id, plane, departure, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival);
        } else {
            flight = new Flight(id, plane, departure, scale, arrival, departureDate, hoursDurationsArrival, minutesDurationsArrival, hoursDurationsScale, minutesDurationsScale);
        }
        flightController.createFlight(flight);
    }

    // --------- OBTENER LISTAS PARA TABLAS ----------
    public List<Passenger> getAllPassengers() {
        return passengerController.getAllPassengers();
    }

    public List<Plane> getAllPlanes() {
        return planeController.getAllPlanes();
    }

    public List<Location> getAllLocations() {
        return locationController.getAllLocations();
    }

   public List<Flight> getAllFlights() {
    return flightController.getAllFlights();
}

    // --------- MÉTODOS EXTRA DE USO FRECUENTE ----------
    public Passenger getPassenger(long id) {
        return passengerController.getPassenger(id);
    }

    public Plane getPlane(String id) {
        return planeController.getPlane(id);
    }

    public Location getLocation(String id) {
        return locationController.getLocation(id);
    }

    public Flight getFlight(String id) {
        return flightController.getFlight(id);
    }

    // Ejemplo de método para actualizar pasajero (si lo necesitas en tu UI)
    public void updatePassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode, long phone, String country) {
        Passenger passenger = passengerController.getPassenger(id);
        passenger.setFirstname(firstname);
        passenger.setLastname(lastname);
        passenger.setBirthDate(LocalDate.of(year, month, day));
        passenger.setCountryPhoneCode(phoneCode);
        passenger.setPhone(phone);
        passenger.setCountry(country);
        passengerController.updatePassenger(passenger);
    }

    // Ejemplo de método para obtener los vuelos de un pasajero específico
    public List<Flight> getFlightsByPassenger(long passengerId) {
        return passengerController.getPassenger(passengerId).getFlights();
    }

    // Ejemplo: retrasar vuelo
    public void delayFlight(String flightId, int hours, int minutes) {
        Flight flight = flightController.getFlight(flightId);
        flight.delay(hours, minutes);
        flightController.updateFlight(flight);
    }

    // Ejemplo: agregar pasajero a vuelo
    public void addPassengerToFlight(long passengerId, String flightId) {
        Passenger passenger = passengerController.getPassenger(passengerId);
        Flight flight = flightController.getFlight(flightId);

        if (flight.getPassengers().contains(passenger)) {
            throw new IllegalArgumentException("El pasajero ya está en el vuelo.");
        }

        flight.addPassenger(passenger);
        passenger.addFlight(flight);

        flightController.updateFlight(flight);
        passengerController.updatePassenger(passenger);
    }
}
