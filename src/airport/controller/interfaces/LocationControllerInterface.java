package airport.controller.interfaces;

import java.util.List;
import airport.model.Location;

public interface LocationControllerInterface {
    Location createLocation(String id, String name, String city, String country, double latitude, double longitude);
    Location getLocation(String id);
    List<Location> getAllLocations();
    Location updateLocation(Location location);
    void removeLocation(String id);
}