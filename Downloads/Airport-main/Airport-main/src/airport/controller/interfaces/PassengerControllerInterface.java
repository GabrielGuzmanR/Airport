package airport.controller.interfaces;

import java.util.List;
import airport.model.Passenger;

public interface PassengerControllerInterface {
    Passenger createPassenger(Passenger passenger);
    Passenger getPassenger(long id);
    List<Passenger> getAllPassengers();
    Passenger updatePassenger(Passenger passenger);
    void removePassenger(long id);
}