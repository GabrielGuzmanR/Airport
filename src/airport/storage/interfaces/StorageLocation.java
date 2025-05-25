package airport.storage.interfaces;

import airport.model.Location;
import java.util.List;

public interface StorageLocation {
    void addLocation(Location l);

    boolean existsLocation(String id);

    Location getLocationById(String id);

    List<Location> getAllLocations();

    void updateLocation(Location l);

    void removeLocation(String id);
}