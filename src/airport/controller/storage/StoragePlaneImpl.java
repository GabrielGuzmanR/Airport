package airport.controller.storage;

import airport.model.Plane;
import java.util.*;

public class StoragePlaneImpl implements StoragePlane {
    private final Map<String, Plane> planeMap = new HashMap<>();

    @Override
    public void addPlane(Plane plane) {
        if (planeMap.containsKey(plane.getId())) {
            throw new IllegalArgumentException("Plane ID must be unique");
        }
        planeMap.put(plane.getId(), plane);
    }

    @Override
    public Plane getPlaneById(String id) {
        Plane p = planeMap.get(id);
        return (p != null) ? p.clone() : null;
    }

    @Override
    public List<Plane> getAllPlanes() {
        List<Plane> planes = new ArrayList<>();
        for (Plane p : planeMap.values()) {
            planes.add(p.clone());
        }
        planes.sort(Comparator.comparing(Plane::getId));
        return planes;
    }

    @Override
    public void updatePlane(Plane plane) {
        if (!planeMap.containsKey(plane.getId())) {
            throw new IllegalArgumentException("Plane does not exist");
        }
        planeMap.put(plane.getId(), plane);
    }

    @Override
    public void removePlane(String id) {
        planeMap.remove(id);
    }

    @Override
    public boolean existsPlane(String id) {
        return planeMap.containsKey(id);
    }
}