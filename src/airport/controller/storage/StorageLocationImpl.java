package airport.controller.storage;

import airport.model.Location;
import java.util.*;

public class StorageLocationImpl implements StorageLocation {
    private final Map<String, Location> locationMap = new HashMap<>();

    @Override
    public void addLocation(Location location) {
        if (locationMap.containsKey(location.getAirportId())) {
            throw new IllegalArgumentException("Location ID must be unique");
        }
        locationMap.put(location.getAirportId(), location);
    }

    @Override
    public Location getLocationById(String id) {
        Location loc = locationMap.get(id);
        return (loc != null) ? loc.clone() : null;
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        for (Location l : locationMap.values()) {
            locations.add(l.clone());
        }
        // Opcional: ordenar por nombre de aeropuerto
        locations.sort(Comparator.comparing(Location::getAirportName));
        return locations;
    }

    @Override
    public void updateLocation(Location location) {
        if (!locationMap.containsKey(location.getAirportId())) {
            throw new IllegalArgumentException("Location does not exist");
        }
        locationMap.put(location.getAirportId(), location);
    }

    @Override
    public void removeLocation(String id) {
        locationMap.remove(id);
    }

    @Override
    public boolean existsLocation(String id) {
        return locationMap.containsKey(id);
    }
}