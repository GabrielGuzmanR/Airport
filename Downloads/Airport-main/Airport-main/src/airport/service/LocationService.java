package airport.service;

import java.util.List;

import airport.model.Location;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.interfaces.StorageLocation;

/** Servicio que gestiona operaciones y validaciones del modelo Location. **/
public class LocationService {

    private final StorageLocation storage;
    private final ValidatorInterface<Location> validator;

    /**
     * Se usa la interfaces y no las impementaciones concretas DIP(Inversión de
     * dependencias)
     **/
    public LocationService(StorageLocation storage, ValidatorInterface<Location> validator) {
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

    /** Permite obtener una ubicación por medio del ID **/
    public Location getLocation(String id) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede estar vació.");
        }

        Location location = this.storage.getLocationById(id);
        if (location == null) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        return location;
    }

    /** Permite obtener todas las ubicaciones registradas **/
    public List<Location> getAllLocations() {

        List<Location> locations = this.storage.getAllLocations();

        if (locations.isEmpty()) {
            throw new IllegalArgumentException("No se encontrarón ubicaciones registradas.");
        }

        return locations;
    }

    /** Permite actualizar la información de una ubicación */
    public void updateLocation(Location updated) {

        if (!this.storage.existsLocation(updated.getAirportId())) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }

        /** Se valida la información, antes de actualizarla **/
        this.validator.validate(updated);

        this.storage.updateLocation(updated);
    }

    /** Permite eliminar la información de una ubicación **/
    public void removeLocation(String id) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede estar vació.");
        }

        if (!this.storage.existsLocation(id)) {
            throw new IllegalArgumentException("La ubicación con el ID especificado no existe.");
        }
        this.storage.removeLocation(id);
    }
}
