package airport.service;

import java.util.List;

import airport.model.Location;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.StorageLocation;

public class LocationService {

    private final StorageLocation storage;
    private final ValidatorInterface<Location> validator;

    /**
     * Se usa la interfaces y no las impementaciones concretas DIP(Inversión de
     * dependencias)
     **/
    LocationService(StorageLocation storage, ValidatorInterface<Location> validator) {
        this.storage = storage;
        this.validator = validator;
    }

    /** Permite crear un nuevo registro, haciendo uso del repositorio **/
    public void createLocation(String id, String name, String city, String country, double latitude, double longitude) {

        Location location = new Location(id, name, city, country, latitude, longitude);

        /** Se valida si ya existe una location(ubicación) con ese ID **/
        if (this.storage.existsLocation(id)) {
            throw new IllegalArgumentException("Ya existe una ubicación con ese ID.");
        }

        /** Se valida la información, antes de insertarla **/
        this.validator.validate(location);

        this.storage.addLocation(location);
    }

    public Location getLocation(String id) {
        Location location = this.storage.getLocationById(id);
        if (location == null) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        return location;
    }

    public List<Location> getAllLocations() {
        return this.storage.getAllLocations();
    }

    public void updateLocation(Location updated) {
        if (!this.storage.existsLocation(updated.getAirportId())) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        this.storage.updateLocation(updated);
    }

    public void removeLocation(String id) {
        if (!this.storage.existsLocation(id)) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        this.storage.removeLocation(id);
    }
}
