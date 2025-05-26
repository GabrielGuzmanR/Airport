package airport.controller.impl;

import airport.controller.interfaces.FlightControllerInterface;
import airport.model.Flight;
import airport.service.impl.FlightService;

import java.util.List;

public class Flight_Controller implements FlightControllerInterface {
    private final FlightService flightService;

    public Flight_Controller(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public Flight createFlight(Flight flight) {
        this.flightService.createFlight(flight);
        return flight;
    }

    @Override
    public Flight getFlight(String id) {
        return this.flightService.getFlight(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return this.flightService.getAllFlights();
    }

    @Override
    public Flight updateFlight(Flight updated) {
        this.flightService.updateFlight(updated);
        return updated;
    }

    @Override
    public void removeFlight(String id) {
        this.flightService.removeFlight(id);
    }
}