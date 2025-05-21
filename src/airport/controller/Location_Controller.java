package airport.controller;

import airport.model.Location;
import airport.controller.storage.StorageLocation;
import java.util.List;

public class Location_Controller {
    private final StorageLocation storage;

    public Location_Controller(StorageLocation storage) {
        this.storage = storage;
    }

    public void createLocation(Location location) {
        if (storage.existsLocation(location.getAirportId())) {
            throw new IllegalArgumentException("Ya existe una ubicación con ese ID.");
        }
        storage.addLocation(location);
    }

    public Location getLocation(String id) {
        Location location = storage.getLocationById(id);
        if (location == null) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        return location;
    }

    public List<Location> getAllLocations() {
        return storage.getAllLocations();
    }

    public void updateLocation(Location updated) {
        if (!storage.existsLocation(updated.getAirportId())) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        storage.updateLocation(updated);
    }

    public void removeLocation(String id) {
        if (!storage.existsLocation(id)) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        storage.removeLocation(id);
    }
}