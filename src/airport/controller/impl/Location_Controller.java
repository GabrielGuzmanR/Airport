package airport.controller.impl;

import airport.controller.interfaces.LocationControllerInterface;
import airport.model.Location;
import airport.service.impl.LocationService;

import java.util.List;

public class Location_Controller implements LocationControllerInterface {

    private final LocationService locationService;

    /** Se inyecta el servicio de LocationService **/
    public Location_Controller(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Location createLocation(String id, String name, String city, String country, double latitude,
            double longitude) {
        this.locationService.createLocation(id, name, city, country, latitude, longitude);
        // Se retorna la Location recién creada desde el servicio (por id)
        return this.locationService.getLocation(id);
    }

    @Override
    public Location getLocation(String id) {
        return this.locationService.getLocation(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return this.locationService.getAllLocations();
    }

    @Override
    public Location updateLocation(Location updated) {
        this.locationService.updateLocation(updated);
        return updated;
    }

    @Override
    public void removeLocation(String id) {
        this.locationService.removeLocation(id);
    }
}