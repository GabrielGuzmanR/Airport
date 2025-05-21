package airport.controller.storage;

import airport.model.Flight;
import java.util.*;

public class StorageFlightImpl implements StorageFlight {
    private final Map<String, Flight> flightMap = new HashMap<>();

    @Override
    public void addFlight(Flight flight) {
        if (flightMap.containsKey(flight.getId())) {
            throw new IllegalArgumentException("Flight ID must be unique");
        }
        flightMap.put(flight.getId(), flight);
    }

    @Override
    public Flight getFlightById(String id) {
        Flight flight = flightMap.get(id);
        return (flight != null) ? flight.clone() : null;
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        for (Flight f : flightMap.values()) {
            flights.add(f.clone());
        }
        // Optional: Sort by departure date
        flights.sort(Comparator.comparing(Flight::getDepartureDate));
        return flights;
    }

    @Override
    public void updateFlight(Flight flight) {
        if (!flightMap.containsKey(flight.getId())) {
            throw new IllegalArgumentException("Flight does not exist");
        }
        flightMap.put(flight.getId(), flight);
    }

    @Override
    public void removeFlight(String id) {
        flightMap.remove(id);
    }

    @Override
    public boolean existsFlight(String id) {
        return flightMap.containsKey(id);
    }
}