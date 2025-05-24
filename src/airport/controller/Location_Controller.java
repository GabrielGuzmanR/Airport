package airport.controller;

import airport.model.Location;
import airport.service.LocationService;

import java.util.List;

public class Location_Controller {
    private final LocationService locationService;

    /** Se inyecta el servicio de LocationService(Inyección de dependencias) **/
    public Location_Controller(LocationService locationService) {
        this.locationService = locationService;
    }

    /** Permite delegar a la capa de servicios, para crear la Locación **/
    public void createLocation(String id, String name, String city, String country, double latitude, double longitude) {
        this.locationService.createLocation(id, name, city, country, latitude, longitude);
    }

    /**
     * Permite delegar a la capa de servicios, para obtener una locación por medio
     * del ID
     **/
    public Location getLocation(String id) {
        return this.locationService.getLocation(id);
    }

    /**
     * Permite delegar a la capa de servicios, para obtener todas las locaciones
     * guardadas
     **/
    public List<Location> getAllLocations() {
        return this.locationService.getAllLocations();
    }

    /**
     * Permite delegar a la capa de servicios, para actualizar la información de una
     * locación
     **/
    public void updateLocation(Location updated) {
        this.locationService.updateLocation(updated);
    }

    /**
     * Permite delegar a la capa de servicios, para eliminar la locación por medio
     * del ID
     **/
    public void removeLocation(String id) {
        this.locationService.removeLocation(id);
    }
}