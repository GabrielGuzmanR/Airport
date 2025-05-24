package airport.controller;

import airport.model.Plane;
import airport.service.PlaneService;
import airport.controller.interfaces.PlaneControllerInterface;

import java.util.List;

public class Plane_Controller implements PlaneControllerInterface {

    private final PlaneService planeService;

    public Plane_Controller(PlaneService planeService) {
        this.planeService = planeService;
    }

    @Override
    public Plane createPlane(String id, String brand, String model, int maxCapacity, String airline) {
        this.planeService.createPlane(id, brand, model, maxCapacity, airline);
        return this.planeService.getPlane(id);
    }

    @Override
    public Plane getPlane(String id) {
        return this.planeService.getPlane(id);
    }

    @Override
    public List<Plane> getAllPlanes() {
        return this.planeService.getAllPlanes();
    }

    @Override
    public Plane updatePlane(Plane updated) {
        this.planeService.updatePlane(updated);
        return updated;
    }

    @Override
    public void removePlane(String id) {
        this.planeService.removePlane(id);
    }
}