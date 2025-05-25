package airport.controller.interfaces;

import java.util.List;
import airport.model.Flight;

public interface FlightControllerInterface {
    Flight createFlight(Flight flight);
    Flight getFlight(String id);
    List<Flight> getAllFlights();
    Flight updateFlight(Flight flight);
    void removeFlight(String id);
}