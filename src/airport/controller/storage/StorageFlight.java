package airport.controller.storage;

import airport.model.Flight;
import java.util.List;

public interface StorageFlight {
    void addFlight(Flight f);
    boolean existsFlight(String id);
    Flight getFlightById(String id);
    List<Flight> getAllFlights();
    void updateFlight(Flight f);
    void removeFlight(String id);
}