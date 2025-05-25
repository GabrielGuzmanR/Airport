package airport.controller;

import airport.model.Plane;
import airport.storage.StoragePlane;

import java.util.List;

public class Plane_Controller {
    private final StoragePlane storage;

    public Plane_Controller(StoragePlane storage) {
        this.storage = storage;
    }

    public void createPlane(String id, String brand, String model, int maxCapacity, String airline) {
        if (storage.existsPlane(id)) {
            throw new IllegalArgumentException("Ya existe un avión con ese ID.");
        }
        Plane plane = new Plane(id, brand, model, maxCapacity, airline);
        storage.addPlane(plane);
    }

    public Plane getPlane(String id) {
        Plane plane = storage.getPlaneById(id);
        if (plane == null) {
            throw new IllegalArgumentException("El avión con el ID especificado no existe.");
        }
        return plane;
    }

    public List<Plane> getAllPlanes() {
        return storage.getAllPlanes();
    }

    public void updatePlane(Plane updated) {
        if (!storage.existsPlane(updated.getId())) {
            throw new IllegalArgumentException("El avión con el ID especificado no existe.");
        }
        storage.updatePlane(updated);
    }

    public void removePlane(String id) {
        if (!storage.existsPlane(id)) {
            throw new IllegalArgumentException("El avión con el ID especificado no existe.");
        }
        storage.removePlane(id);
    }
}