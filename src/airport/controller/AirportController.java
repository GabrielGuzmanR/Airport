package airport.controller;

import airport.controller.interfaces.FlightControllerInterface;
import airport.controller.interfaces.LocationControllerInterface;
import airport.controller.interfaces.PassengerControllerInterface;
import airport.controller.interfaces.PlaneControllerInterface;
import airport.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirportController {

    private final PlaneControllerInterface planeController;
    private final FlightControllerInterface flightController;
    private final LocationControllerInterface locationController;
    private final PassengerControllerInterface passengerController;

    public AirportController(
            PlaneControllerInterface planeController,
            FlightControllerInterface flightController,
            LocationControllerInterface locationController,
            PassengerControllerInterface passengerController) {
        this.planeController = planeController;
        this.flightController = flightController;
        this.locationController = locationController;
        this.passengerController = passengerController;
    }

    // --------- CREAR ENTIDADES ----------
    public Response<Passenger> registerPassenger(long id, String firstname, String lastname, int year, int month, int day,
            int phoneCode, long phone, String country) {
        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            Passenger passenger = new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country);
            Passenger created = passengerController.createPassenger(passenger);
            return new Response<>(201, "Pasajero registrado con éxito.", created.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al registrar pasajero: " + e.getMessage(), null);
        }
    }

    public Response<Plane> createPlane(String id, String brand, String model, int maxCapacity, String airline) {
        try {
            Plane plane = planeController.createPlane(id, brand, model, maxCapacity, airline);
            return new Response<>(201, "Avión creado con éxito.", plane.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al crear avión: " + e.getMessage(), null);
        }
    }

    public Response<Location> createLocation(String id, String name, String city, String country, double latitude, double longitude) {
        try {
            Location location = locationController.createLocation(id, name, city, country, latitude, longitude);
            return new Response<>(201, "Ubicación creada con éxito.", location.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al crear ubicación: " + e.getMessage(), null);
        }
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
        try {
            Plane plane = planeController.getPlane(planeId);
            Location departure = locationController.getLocation(departureLocationId);
            Location arrival = locationController.getLocation(arrivalLocationId);
            Location scale = (scaleLocationId != null && !scaleLocationId.isEmpty() && !scaleLocationId.equals("-"))
                    ? locationController.getLocation(scaleLocationId)
                    : null;

            LocalDateTime departureDate = LocalDateTime.of(year, month, day, hour, minutes);

            Flight flight;
            if (scale == null) {
                flight = new Flight(id, plane, departure, arrival, departureDate, hoursDurationsArrival,
                        minutesDurationsArrival);
            } else {
                flight = new Flight(id, plane, departure, scale, arrival, departureDate, hoursDurationsArrival,
                        minutesDurationsArrival, hoursDurationsScale, minutesDurationsScale);
            }
            Flight created = flightController.createFlight(flight);
            return new Response<>(201, "Vuelo creado con éxito.", created.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al crear vuelo: " + e.getMessage(), null);
        }
    }

    // --------- OBTENER LISTAS PARA TABLAS (ordenadas, copias) ----------
    public Response<List<Passenger>> getAllPassengers() {
        try {
            List<Passenger> sorted = passengerController.getAllPassengers().stream()
                    .sorted(Comparator.comparingLong(Passenger::getId))
                    .map(Passenger::clone)
                    .collect(Collectors.toList());
            return new Response<>(200, "Pasajeros obtenidos con éxito.", sorted);
        } catch (Exception e) {
            return new Response<>(400, "Error al obtener pasajeros: " + e.getMessage(), null);
        }
    }

    public Response<List<Plane>> getAllPlanes() {
        try {
            List<Plane> sorted = planeController.getAllPlanes().stream()
                    .sorted(Comparator.comparing(Plane::getId))
                    .map(Plane::clone)
                    .collect(Collectors.toList());
            return new Response<>(200, "Aviones obtenidos con éxito.", sorted);
        } catch (Exception e) {
            return new Response<>(400, "Error al obtener aviones: " + e.getMessage(), null);
        }
    }

    public Response<List<Location>> getAllLocations() {
        try {
            List<Location> sorted = locationController.getAllLocations().stream()
                    .sorted(Comparator.comparing(Location::getAirportId))
                    .map(Location::clone)
                    .collect(Collectors.toList());
            return new Response<>(200, "Ubicaciones obtenidas con éxito.", sorted);
        } catch (Exception e) {
            return new Response<>(400, "Error al obtener ubicaciones: " + e.getMessage(), null);
        }
    }

    public Response<List<Flight>> getAllFlights() {
        try {
            List<Flight> sorted = flightController.getAllFlights().stream()
                    .sorted(Comparator.comparing(Flight::getDepartureDate))
                    .map(Flight::clone)
                    .collect(Collectors.toList());
            return new Response<>(200, "Vuelos obtenidos con éxito.", sorted);
        } catch (Exception e) {
            return new Response<>(400, "Error al obtener vuelos: " + e.getMessage(), null);
        }
    }

    // --------- MÉTODOS EXTRA DE USO FRECUENTE ----------
    public Response<Passenger> updatePassenger(long id, String firstname, String lastname, int year, int month, int day, int phoneCode,
            long phone, String country) {
        try {
            Passenger passenger = passengerController.getPassenger(id);
            passenger.setFirstname(firstname);
            passenger.setLastname(lastname);
            passenger.setBirthDate(LocalDate.of(year, month, day));
            passenger.setCountryPhoneCode(phoneCode);
            passenger.setPhone(phone);
            passenger.setCountry(country);
            Passenger updated = passengerController.updatePassenger(passenger);
            return new Response<>(200, "Pasajero actualizado con éxito.", updated.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al actualizar pasajero: " + e.getMessage(), null);
        }
    }

    public Response<List<Flight>> getFlightsByPassenger(long passengerId) {
        try {
            List<Flight> sorted = passengerController.getPassenger(passengerId).getFlights().stream()
                    .sorted(Comparator.comparing(Flight::getDepartureDate))
                    .map(Flight::clone)
                    .collect(Collectors.toList());
            return new Response<>(200, "Vuelos del pasajero obtenidos con éxito.", sorted);
        } catch (Exception e) {
            return new Response<>(400, "Error al obtener vuelos del pasajero: " + e.getMessage(), null);
        }
    }

    public Response<Flight> delayFlight(String flightId, int hours, int minutes) {
        try {
            if (hours < 0 && minutes < 0)
                throw new IllegalArgumentException("El tiempo de retraso debe ser mayor que 00:00.");
            Flight flight = flightController.getFlight(flightId);
            flight.delay(hours, minutes);
            Flight updated = flightController.updateFlight(flight);
            return new Response<>(200, "Vuelo retrasado correctamente.", updated.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al retrasar vuelo: " + e.getMessage(), null);
        }
    }

    public Response<Flight> addPassengerToFlight(long passengerId, String flightId) {
        try {
            Passenger passenger = passengerController.getPassenger(passengerId);
            Flight flight = flightController.getFlight(flightId);

            if (flight.getPassengers().contains(passenger)) {
                throw new IllegalArgumentException("El pasajero ya está en el vuelo.");
            }

            flight.addPassenger(passenger);
            passenger.addFlight(flight);

            Flight updatedFlight = flightController.updateFlight(flight);
            passengerController.updatePassenger(passenger);

            return new Response<>(200, "Pasajero agregado al vuelo correctamente.", updatedFlight.clone());
        } catch (Exception e) {
            return new Response<>(400, "Error al agregar pasajero al vuelo: " + e.getMessage(), null);
        }
    }

    // Facade para obtener por id (devuelve copia)
    public Response<Passenger> getPassenger(long id) {
        try {
            Passenger p = passengerController.getPassenger(id);
            return new Response<>(200, "Pasajero obtenido con éxito.", p.clone());
        } catch (Exception e) {
            return new Response<>(404, "No se encontró el pasajero: " + e.getMessage(), null);
        }
    }

    public Response<Plane> getPlane(String id) {
        try {
            Plane p = planeController.getPlane(id);
            return new Response<>(200, "Avión obtenido con éxito.", p.clone());
        } catch (Exception e) {
            return new Response<>(404, "No se encontró el avión: " + e.getMessage(), null);
        }
    }

    public Response<Location> getLocation(String id) {
        try {
            Location l = locationController.getLocation(id);
            return new Response<>(200, "Ubicación obtenida con éxito.", l.clone());
        } catch (Exception e) {
            return new Response<>(404, "No se encontró la ubicación: " + e.getMessage(), null);
        }
    }

    public Response<Flight> getFlight(String id) {
        try {
            Flight f = flightController.getFlight(id);
            return new Response<>(200, "Vuelo obtenido con éxito.", f.clone());
        } catch (Exception e) {
            return new Response<>(404, "No se encontró el vuelo: " + e.getMessage(), null);
        }
    }
}