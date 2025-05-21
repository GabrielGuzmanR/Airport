package airport.controller;

import airport.model.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class PassengerController {

    private HashMap<Long, Passenger> passengerMap;

    public PassengerController() {
        this.passengerMap = new HashMap<>();
    }

    public Response<Passenger> registerPassenger(long id, String firstname, String lastname, LocalDate birthDate,
                                                 int countryPhoneCode, long phone, String country) {
        // Validaciones
        if (id < 0 || String.valueOf(id).length() > 15) {
            return new Response<>(400, "ID inválido.", null);
        }
        if (passengerMap.containsKey(id)) {
            return new Response<>(400, "ID duplicado.", null);
        }
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            return new Response<>(400, "Fecha de nacimiento inválida.", null);
        }
        if (countryPhoneCode < 0 || String.valueOf(countryPhoneCode).length() > 3) {
            return new Response<>(400, "Código telefónico inválido.", null);
        }
        if (phone < 0 || String.valueOf(phone).length() > 11) {
            return new Response<>(400, "Número telefónico inválido.", null);
        }
        if (firstname == null || firstname.isBlank() ||
            lastname == null || lastname.isBlank() ||
            country == null || country.isBlank()) {
            return new Response<>(400, "Hay campos vacíos.", null);
        }

        // Crear pasajero
        Passenger passenger = new Passenger(id, firstname, lastname, birthDate, countryPhoneCode, phone, country);
        passengerMap.put(id, passenger);

        return new Response<>(201, "Pasajero registrado exitosamente.", passenger);
    }

    public ArrayList<Passenger> getAllPassengersOrdered() {
        return passengerMap.values()
                .stream()
                .sorted((p1, p2) -> Long.compare(p1.getId(), p2.getId()))
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
    }

    // Otros métodos como updatePassenger() irán aquí
}
