package airport.service;

import java.util.List;

import airport.model.Flight;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.interfaces.StorageFlight;

/** Servicio que gestiona operaciones y validaciones del modelo Flight. **/
public class FlightService {

    private final StorageFlight storage;
    private final ValidatorInterface<Flight> validator;

    /**
     * Se usa la interfaces y no las impementaciones concretas DIP(Inversión de
     * dependencias)
     **/
    public FlightService(StorageFlight storage, ValidatorInterface<Flight> validator) {
        this.storage = storage;
        this.validator = validator;
    }

    /** Permite crear un nuevo vuelo, haciendo uso del repositorio **/
    public void createFlight(Flight flight) {

        if (storage.existsFlight(flight.getId())) {
            throw new IllegalArgumentException("Ya existe un vuelo con ese ID.");
        }

        /** Se valida la información, antes de insertarla **/
        this.validator.validate(flight);
        storage.addFlight(flight);
    }

    private void hasValidId(String id) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vació.");
        }
    }

    /** Permite obtener un vuelo por medio del ID **/
    public Flight getFlight(String id) {

        this.hasValidId(id);

        Flight flight = storage.getFlightById(id);
        if (flight == null) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }
        return flight;
    }

    /** Permite obtener todos los vuelos registrados **/
    public List<Flight> getAllFlights() {

        List<Flight> flights = storage.getAllFlights();

        if (flights.isEmpty()) {
            throw new IllegalArgumentException("No se encontrarón vuelos registrados.");
        }
        return flights;
    }

    /** Permite actualizar la información de un vuelo */
    public void updateFlight(Flight updated) {

        this.hasValidId(updated.getId());

        if (!storage.existsFlight(updated.getId())) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }

        /** Se valida la información, antes de actualizarla **/
        this.validator.validate(updated);

        storage.updateFlight(updated);
    }

    /** Permite eliminar la información de un vuelo */
    public void removeFlight(String id) {

        this.hasValidId(id);

        if (!storage.existsFlight(id)) {
            throw new IllegalArgumentException("El vuelo con el ID especificado no existe.");
        }
        storage.removeFlight(id);
    }

}
