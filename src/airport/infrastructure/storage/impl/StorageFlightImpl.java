package airport.infrastructure.storage.impl;

import airport.infrastructure.storage.interfaces.StorageFlight;
import airport.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class StorageFlightImpl implements StorageFlight {
    private final List<Flight> flights;

    public StorageFlightImpl(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    @Override
    public void addFlight(Flight f) {
        flights.add(f);
    }

    @Override
    public boolean existsFlight(String id) {
        return flights.stream().anyMatch(f -> f.getId().equals(id));
    }

    @Override
    public Flight getFlightById(String id) {
        return flights.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    @Override
    public void updateFlight(Flight updated) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId().equals(updated.getId())) {
                flights.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void removeFlight(String id) {
        flights.removeIf(f -> f.getId().equals(id));
    }
}