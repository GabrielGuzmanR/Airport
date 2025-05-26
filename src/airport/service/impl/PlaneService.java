package airport.service.impl;

import java.util.List;

import airport.infrastructure.storage.interfaces.StoragePlane;
import airport.model.Plane;
import airport.service.validator.interfaces.ValidatorInterface;

/**
 * Servicio que gestiona operaciones y validaciones del modelo Plane. *
 */
public class PlaneService {

    private final StoragePlane storage;
    private final ValidatorInterface<Plane> validator;

    /**
     * Se usan las interfaces y no las impementaciones concretas DIP(Inversión
     * de dependencias)
     *
     */
    public PlaneService(StoragePlane storage, ValidatorInterface<Plane> validator) {
        this.storage = storage;
        this.validator = validator;
    }

    public Plane getPlane(String id) {
        this.hasValidId(id);
        return this.storage.getPlaneById(id); // No lanzar excepción si no existe
    }

    private void hasValidId(String id) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vació.");
        }
    }

    /**
     * Permite crear un nuevo avión, haciendo uso del repositorio *
     */
    public void createPlane(String id, String brand, String model, int maxCapacity, String airline) {

        if (this.storage.existsPlane(id)) {
            throw new IllegalArgumentException("Ya existe un avión con ese ID.");
        }
        Plane plane = new Plane(id, brand, model, maxCapacity, airline);

        /**
         * Se valida la información, antes de insertarla *
         */
        this.validator.validate(plane);

        this.storage.addPlane(plane);
    }

    /**
     * Permite obtener un avión por medio del ID *
     */
    /**
     * Permite obtener todos los aviones registrados *
     */
    public List<Plane> getAllPlanes() {

        List<Plane> planes = this.storage.getAllPlanes();

        if (planes.isEmpty()) {
            throw new IllegalArgumentException("No se encontrarón aviones registrados.");
        }

        return planes;
    }

    /**
     * Permite actualizar la información de un avión
     */
    public void updatePlane(Plane updated) {

        this.hasValidId(updated.getId());

        if (!this.storage.existsPlane(updated.getId())) {
            throw new IllegalArgumentException("El avión con el ID especificado no existe.");
        }

        /**
         * Se valida la información, antes de actualizarla *
         */
        this.validator.validate(updated);

        this.storage.updatePlane(updated);
    }

    /**
     * Permite eliminar la información de un avión
     */
    public void removePlane(String id) {

        this.hasValidId(id);

        if (!this.storage.existsPlane(id)) {
            throw new IllegalArgumentException("El avión con el ID especificado no existe.");
        }
        this.storage.removePlane(id);
    }
}
