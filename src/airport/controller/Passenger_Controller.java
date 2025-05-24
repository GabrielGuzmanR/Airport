package airport.controller;

import airport.controller.interfaces.PassengerControllerInterface;
import airport.model.Passenger;
import airport.service.PassengerService;

import java.util.List;

public class Passenger_Controller implements PassengerControllerInterface {

    private final PassengerService passengerService;

    public Passenger_Controller(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        this.passengerService.createPassenger(passenger);
        return passenger;
    }

    @Override
    public Passenger getPassenger(long id) {
        return this.passengerService.getPassenger(id);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return this.passengerService.getAllPassengers();
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        this.passengerService.updatePassenger(passenger);
        return passenger;
    }

    @Override
    public void removePassenger(long id) {
        this.passengerService.removePassenger(id);
    }
}