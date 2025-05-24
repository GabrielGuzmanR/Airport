package airport.controller;

import airport.model.Passenger;
import airport.storage.StoragePassenger;

import java.util.List;

public class Passenger_Controller {
    private final StoragePassenger storage;

    public Passenger_Controller(StoragePassenger storage) {
        this.storage = storage;
    }

    public void createPassenger(Passenger passenger) {
        if (storage.existsPassenger(passenger.getId())) {
            throw new IllegalArgumentException("Ya existe un pasajero con ese ID.");
        }
        storage.addPassenger(passenger);
    }

    public Passenger getPassenger(long id) {
        Passenger passenger = storage.getPassengerById(id);
        if (passenger == null) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }
        return passenger;
    }

    public List<Passenger> getAllPassengers() {
        return storage.getAllPassengers();
    }

    public void updatePassenger(Passenger passenger) {
        if (!storage.existsPassenger(passenger.getId())) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }
        storage.updatePassenger(passenger);
    }

    public void removePassenger(long id) {
        if (!storage.existsPassenger(id)) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }
        storage.removePassenger(id);
    }
}