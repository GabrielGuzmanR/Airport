package airport.controller.storage;

import airport.model.Location;
import java.util.ArrayList;
import java.util.List;

public class StorageLocationImpl implements StorageLocation {
    private final List<Location> locations;

    public StorageLocationImpl(List<Location> locations) {
        this.locations = new ArrayList<>(locations);
    }

    @Override
    public void addLocation(Location l) {
        locations.add(l);
    }

    @Override
    public boolean existsLocation(String id) {
        return locations.stream().anyMatch(l -> l.getAirportId().equals(id));
    }

    @Override
    public Location getLocationById(String id) {
        return locations.stream().filter(l -> l.getAirportId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return new ArrayList<>(locations);
    }

    @Override
    public void updateLocation(Location updated) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getAirportId().equals(updated.getAirportId())) {
                locations.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void removeLocation(String id) {
        locations.removeIf(l -> l.getAirportId().equals(id));
    }
}