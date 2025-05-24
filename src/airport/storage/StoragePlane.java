package airport.storage;

import airport.model.Plane;
import java.util.List;

public interface StoragePlane {
    void addPlane(Plane p);

    boolean existsPlane(String id);

    Plane getPlaneById(String id);

    List<Plane> getAllPlanes();

    void updatePlane(Plane p);

    void removePlane(String id);
}