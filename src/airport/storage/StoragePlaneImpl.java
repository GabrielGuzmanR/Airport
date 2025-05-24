package airport.storage;

import airport.model.Plane;
import java.util.ArrayList;
import java.util.List;

public class StoragePlaneImpl implements StoragePlane {
    private final List<Plane> planes;

    public StoragePlaneImpl(List<Plane> planes) {
        this.planes = new ArrayList<>(planes);
    }

    @Override
    public void addPlane(Plane p) {
        planes.add(p);
    }

    @Override
    public boolean existsPlane(String id) {
        return planes.stream().anyMatch(p -> p.getId().equals(id));
    }

    @Override
    public Plane getPlaneById(String id) {
        return planes.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Plane> getAllPlanes() {
        return new ArrayList<>(planes);
    }

    @Override
    public void updatePlane(Plane updated) {
        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getId().equals(updated.getId())) {
                planes.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void removePlane(String id) {
        planes.removeIf(p -> p.getId().equals(id));
    }
}