package airport.controller.storage;

import airport.model.Location;
import java.util.List;

public interface StorageLocation {
    void addLocation(Location location);
    Location getLocationById(String id);
    List<Location> getAllLocations();
    void updateLocation(Location location);
    void removeLocation(String id);
    boolean existsLocation(String id);
}