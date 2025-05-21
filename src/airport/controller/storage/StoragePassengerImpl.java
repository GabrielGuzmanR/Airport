package airport.controller.storage;

import airport.model.Passenger;
import java.util.*;

public class StoragePassengerImpl implements StoragePassenger {
    private final Map<Long, Passenger> passengerMap = new HashMap<>();

    @Override
    public void addPassenger(Passenger passenger) {
        if (passengerMap.containsKey(passenger.getId())) {
            throw new IllegalArgumentException("Passenger ID must be unique");
        }
        passengerMap.put(passenger.getId(), passenger);
    }

    @Override
    public Passenger getPassengerById(long id) {
        Passenger p = passengerMap.get(id);
        return (p != null) ? p.clone() : null;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Passenger> list = new ArrayList<>();
        for (Passenger p : passengerMap.values()) {
            list.add(p.clone());
        }
        list.sort(Comparator.comparingLong(Passenger::getId));
        return list;
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        if (!passengerMap.containsKey(passenger.getId())) {
            throw new IllegalArgumentException("Passenger does not exist");
        }
        passengerMap.put(passenger.getId(), passenger);
    }

    @Override
    public void removePassenger(long id) {
        passengerMap.remove(id);
    }

    @Override
    public boolean existsPassenger(long id) {
        return passengerMap.containsKey(id);
    }
}