package airport.service;

import java.util.List;

import airport.model.Passenger;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.interfaces.StoragePassenger;

/**
 * Servicio que gestiona operaciones y validaciones del modelo
 * Passenger(Pasajeros).
 **/
public class PassengerService {

    private final StoragePassenger storage;
    private final ValidatorInterface<Passenger> validator;

    /**
     * Se usan las interfaces y no las impementaciones concretas DIP(Inversión de
     * dependencias)
     **/
    public PassengerService(StoragePassenger storage, ValidatorInterface<Passenger> validator) {
        this.storage = storage;
        this.validator = validator;
    }

    private void hasValidId(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID no puede estar nulo y debe ser mayor a 0.");
        }
    }

    /** Permite crear un nuevo pasajero, haciendo uso del repositorio **/
    public void createPassenger(Passenger passenger) {

        System.out.println("Servicio => createPassenger");
        if (this.storage.existsPassenger(passenger.getId())) {

            throw new IllegalArgumentException("Ya existe un pasajero con ese ID.");
        }
        /** Se valida la información, antes de insertarla **/
        System.out.println("Servicio => Validador");
        this.validator.validate(passenger);

        System.out.println("Servicio => Registro");
        this.storage.addPassenger(passenger);
        System.out.println("Servicio => Fin");
    }

    /** Permite obtener un pasajero por medio del ID **/
    public Passenger getPassenger(long id) {

        this.hasValidId(id);

        Passenger passenger = this.storage.getPassengerById(id);
        if (passenger == null) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }
        return passenger;
    }

    /** Permite obtener todos los pasajeros registrados **/
    public List<Passenger> getAllPassengers() {

        System.out.println("Servicio => getAllPassengers");
        List<Passenger> passengers = this.storage.getAllPassengers();

        if (passengers.isEmpty()) {

            throw new IllegalArgumentException("No se encontrarón pasajeros registrados.");
        }

        System.out.println("Servicio => Todos");

        return passengers;
    }

    /** Permite actualizar la información de un pasajero */
    public void updatePassenger(Passenger passenger) {

        this.hasValidId(passenger.getId());

        if (!this.storage.existsPassenger(passenger.getId())) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }

        /** Se valida la información, antes de actualizarla **/
        this.validator.validate(passenger);

        this.storage.updatePassenger(passenger);
    }

    /** Permite eliminar aun pasajero */
    public void removePassenger(long id) {

        this.hasValidId(id);

        if (!this.storage.existsPassenger(id)) {
            throw new IllegalArgumentException("El pasajero con el ID especificado no existe.");
        }

        this.storage.removePassenger(id);
    }

}
