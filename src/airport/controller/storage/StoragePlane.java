package airport.controller.storage;

import airport.model.Plane;
import java.util.List;

public interface StoragePlane {
    void addPlane(Plane plane);
    Plane getPlaneById(String id);
    List<Plane> getAllPlanes();
    void updatePlane(Plane plane);
    void removePlane(String id);
    boolean existsPlane(String id);
}