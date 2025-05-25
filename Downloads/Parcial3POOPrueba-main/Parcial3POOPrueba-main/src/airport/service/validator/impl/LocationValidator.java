package airport.service.validator.impl;

import airport.model.Location;
import airport.service.validator.interfaces.ValidatorInterface;

public class LocationValidator implements ValidatorInterface<Location> {

    @Override
    public void validate(Location location) {
        validateId(location.getAirportId());
        validateString(location.getAirportName(), "name");
        validateString(location.getAirportCity(), "city");
        validateString(location.getAirportCountry(), "country");
        validateLatitude(location.getAirportLatitude());
        validateLongitude(location.getAirportLongitude());
    }

    private void validateId(String id) {
        if (id == null || !id.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Airport id must be exactly 3 uppercase letters");
        }
    }

    private void validateString(String s, String field) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport " + field + " cannot be empty");
        }
    }

    private void validateLatitude(double lat) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Airport latitude must be in range [-90, 90]");
        }
        if (String.valueOf(Math.abs(lat)).contains(".") && String.valueOf(lat).split("\\.")[1].length() > 4) {
            throw new IllegalArgumentException("Airport latitude must have at most 4 decimal places");
        }
    }

    private void validateLongitude(double lon) {
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Airport longitude must be in range [-180, 180]");
        }
        if (String.valueOf(Math.abs(lon)).contains(".") && String.valueOf(lon).split("\\.")[1].length() > 4) {
            throw new IllegalArgumentException("Airport longitude must have at most 4 decimal places");
        }
    }

}
