package airport.controller.storage;

import airport.model.Passenger;
import java.util.List;

public interface StoragePassenger {
    void addPassenger(Passenger passenger);
    Passenger getPassengerById(long id);
    List<Passenger> getAllPassengers();
    void updatePassenger(Passenger passenger);
    void removePassenger(long id);
    boolean existsPassenger(long id);
}