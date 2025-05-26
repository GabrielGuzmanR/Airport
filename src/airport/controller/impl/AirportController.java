package airport.controller.impl;

import java.util.List;

import airport.controller.Response;
import airport.model.*;
import airport.service.impl.AirportService;
import airport.service.record.FlightRecord;

public class AirportController {

    private final AirportService airportService;

    /** Se inyecta el servicio de AirportService **/
    public AirportController(AirportService airportService) {

        this.airportService = airportService;
    }

    public Response<Passenger> registerPassenger(long id, String firstname, String lastname, int year, int month,
            int day,
            int phoneCode, long phone, String country) {

        return this.airportService.registerPassenger(id, firstname, lastname, year, month, day, phoneCode, phone,
                country);
    }

    public Response<Plane> createPlane(String id, String brand, String model, int maxCapacity, String airline) {

        return this.airportService.createPlane(id, brand, model, maxCapacity, airline);
    }

    public Response<Location> createLocation(String id, String name, String city, String country, double latitude,
            double longitude) {

        return this.airportService.createLocation(id, name, city, country, latitude, longitude);
    }

    public Response<Flight> createFlight(
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
            int minutesDurationsScale) {

        FlightRecord info = new FlightRecord(id,
                planeId,
                departureLocationId,
                arrivalLocationId,
                scaleLocationId,
                year,
                month,
                day,
                hour,
                minutes,
                hoursDurationsArrival,
                minutesDurationsArrival,
                hoursDurationsScale,
                minutesDurationsScale);
        return this.airportService.createFlight(info);
    }

    // --------- OBTENER LISTAS PARA TABLAS (ordenadas, copias) ----------
    public Response<List<Passenger>> getAllPassengers() {

        return this.airportService.getAllPassengers();
    }

    public Response<List<Plane>> getAllPlanes() {

        return this.airportService.getAllPlanes();
    }

    public Response<List<Location>> getAllLocations() {

        return this.airportService.getAllLocations();
    }

    public Response<List<Flight>> getAllFlights() {

        return this.airportService.getAllFlights();
    }

    // --------- MÉTODOS EXTRA DE USO FRECUENTE ----------
    public Response<Passenger> updatePassenger(long id, String firstname, String lastname, int year, int month, int day,
            int phoneCode,
            long phone, String country) {

        return this.airportService.updatePassenger(id, firstname, lastname, year, month, day, phoneCode, phone,
                country);
    }

    public Response<Plane> updatePlane(String id, String brand, String model, int maxCapacity, String airline) {

        return this.airportService.updatePlane(id, brand, model, maxCapacity, airline);
    }

    public Response<Location> updateLocation(String id, String name, String city, String country, double latitude,
            double longitude) {

        return this.airportService.updateLocation(id, name, city, country, latitude, longitude);
    }

    public Response<Flight> updateFlight(
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
            int minutesDurationsScale) {

        FlightRecord info = new FlightRecord(id,
                planeId,
                departureLocationId,
                arrivalLocationId,
                scaleLocationId,
                year,
                month,
                day,
                hour,
                minutes,
                hoursDurationsArrival,
                minutesDurationsArrival,
                hoursDurationsScale,
                minutesDurationsScale);

        return this.airportService.updateFlight(info);
    }

    public Response<List<Flight>> getFlightsByPassenger(long passengerId) {

        return this.airportService.getFlightsByPassenger(passengerId);
    }

    public Response<Flight> delayFlight(String flightId, int hours, int minutes) {

        return this.airportService.delayFlight(flightId, hours, minutes);
    }

    public Response<Flight> addPassengerToFlight(long passengerId, String flightId) {

        return this.airportService.addPassengerToFlight(passengerId, flightId);
    }

    public Response<Passenger> getPassenger(long id) {

        return this.airportService.getPassenger(id);
    }

    public Response<Plane> getPlane(String id) {

        return this.airportService.getPlane(id);
    }

    public Response<Location> getLocation(String id) {

        return this.airportService.getLocation(id);
    }

    public Response<Flight> getFlight(String id) {

        return this.airportService.getFlight(id);
    }
}