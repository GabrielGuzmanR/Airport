package airport.service.validator.impl;

import airport.model.Flight;
import airport.service.validator.interfaces.ValidatorInterface;

public class FlightValidator implements ValidatorInterface<Flight> {

    @Override
    public void validate(Flight flight) {
        validateId(flight.getId());
        validateNotNull(flight.getPlane(), "Plane");
        validateNotNull(flight.getDepartureLocation(), "Departure location");
        validateNotNull(flight.getArrivalLocation(), "Arrival location");
        validateNotNull(flight.getDepartureDate(), "Departure date");
        validateDuration(flight.getHoursDurationArrival(), flight.getMinutesDurationArrival(), "flight duration");

        if (flight.getScaleLocation() == null
                && (flight.getHoursDurationScale() != 0 || flight.getMinutesDurationScale() != 0))
            throw new IllegalArgumentException("If scale location is null, scale time must be 0");
        if (flight.getScaleLocation() != null)
            validateDuration(flight.getHoursDurationScale(), flight.getMinutesDurationScale(), "scale duration");
    }

    private void validateId(String id) {
        if (id == null || !id.matches("^[A-Z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Flight id must match format XXXYYY (3 uppercase letters + 3 digits)");
        }
    }

    private void validateNotNull(Object o, String name) {
        if (o == null)
            throw new IllegalArgumentException(name + " cannot be null");
    }

    private void validateDuration(int hours, int minutes, String field) {
        if (hours < 0 || minutes < 0 || (hours == 0 && minutes == 0))
            throw new IllegalArgumentException("The " + field + " must be greater than 00:00");
    }
}
