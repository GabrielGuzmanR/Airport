package airport.controller;

import airport.model.Flight;
import airport.controller.storage.StorageFlight;
import java.util.List;

public class Flight_Controller {
    private final StorageFlight storage;

    public Flight_Controller(StorageFlight storage) {
        this.storage = storage;
    }

    public void createFlight(Flight flight) {
        if (storage.existsFlight(flight.getId())) {
            throw new IllegalArgumentException("Ya existe un vuelo con ese ID.");
        }
        storage.addFlight(flight);
    }

    public Flight getFlight(String id) {
        Flight flight = storage.getFlightById(id);
        if (flight == null) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }
        return flight;
    }

    public List<Flight> getAllFlights() {
        return storage.getAllFlights();
    }

    public void updateFlight(Flight updated) {
        if (!storage.existsFlight(updated.getId())) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }
        storage.updateFlight(updated);
    }

    public void removeFlight(String id) {
        if (!storage.existsFlight(id)) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }
        storage.removeFlight(id);
    }
}