package airport.infrastructure.storage.interfaces;

import airport.model.Passenger;
import java.util.List;

public interface StoragePassenger {
    void addPassenger(Passenger p);

    boolean existsPassenger(long id);

    Passenger getPassengerById(long id);

    List<Passenger> getAllPassengers();

    void updatePassenger(Passenger p);

    void removePassenger(long id);
}