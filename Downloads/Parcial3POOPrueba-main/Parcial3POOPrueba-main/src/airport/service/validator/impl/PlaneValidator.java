package airport.service.validator.impl;

import airport.model.Plane;
import airport.service.validator.interfaces.ValidatorInterface;

public class PlaneValidator implements ValidatorInterface<Plane> {

    public void validate(Plane plane) {
        validateId(plane.getId());
        validateString(plane.getBrand(), "brand");
        validateString(plane.getModel(), "model");
        validateCapacity(plane.getMaxCapacity());
        validateString(plane.getAirline(), "airline");
    }

    private void validateId(String id) {
        if (id == null || !id.matches("^[A-Z]{2}\\d{5}$")) {
            throw new IllegalArgumentException("Plane id must match format XXYYYYY (2 uppercase letters + 5 digits)");
        }
    }

    private void validateString(String s, String field) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Plane " + field + " cannot be empty");
        }
    }

    private void validateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Plane capacity must be greater than 0");
        }
    }
}
