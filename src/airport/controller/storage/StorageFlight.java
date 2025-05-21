package airport.controller.storage;

import airport.model.Flight;
import java.util.List;

public interface StorageFlight {
    void addFlight(Flight flight);
    Flight getFlightById(String id);
    List<Flight> getAllFlights();
    void updateFlight(Flight flight);
    void removeFlight(String id);
    boolean existsFlight(String id);
}