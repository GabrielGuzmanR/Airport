package airport.infrastructure.storage.impl;

import airport.infrastructure.storage.interfaces.StoragePassenger;
import airport.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class StoragePassengerImpl implements StoragePassenger {
    private final List<Passenger> passengers;

    public StoragePassengerImpl(List<Passenger> passengers) {
        this.passengers = new ArrayList<>(passengers);
    }

    @Override
    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    @Override
    public boolean existsPassenger(long id) {
        return passengers.stream().anyMatch(p -> p.getId() == id);
    }

    @Override
    public Passenger getPassengerById(long id) {
        return passengers.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers);
    }

    @Override
    public void updatePassenger(Passenger updated) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getId() == updated.getId()) {
                passengers.set(i, updated);
                return;
            }
        }
    }

    @Override
    public void removePassenger(long id) {
        passengers.removeIf(p -> p.getId() == id);
    }
}