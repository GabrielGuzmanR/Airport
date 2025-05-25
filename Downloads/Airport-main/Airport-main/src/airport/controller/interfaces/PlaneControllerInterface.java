package airport.controller.interfaces;

import java.util.List;
import airport.model.Plane;

public interface PlaneControllerInterface {
    Plane createPlane(String id, String brand, String model, int maxCapacity, String airline);
    Plane getPlane(String id);
    List<Plane> getAllPlanes();
    Plane updatePlane(Plane plane);
    void removePlane(String id);
}