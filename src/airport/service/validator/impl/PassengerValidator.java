package airport.service.validator.impl;

import java.time.LocalDate;

import airport.model.Passenger;
import airport.service.validator.interfaces.ValidatorInterface;

public class PassengerValidator implements ValidatorInterface<Passenger> {

    @Override
    public void validate(Passenger passenger) {

        validateId(passenger.getId());
        validateString(passenger.getFirstname(), "firstname");
        validateString(passenger.getLastname(), "lastname");
        validateBirthDate(passenger.getBirthDate());
        validateCountryPhoneCode(passenger.getCountryPhoneCode());
        validatePhone(passenger.getPhone());
        validateString(passenger.getCountry(), "country");
    }

    // Validations
    private void validateId(long id) {
        if (id < 0 || String.valueOf(id).length() > 15)
            throw new IllegalArgumentException("Passenger id must be >= 0 and at most 15 digits");
    }

    private void validateString(String s, String field) {
        if (s == null || s.trim().isEmpty())
            throw new IllegalArgumentException("Passenger " + field + " cannot be empty");
    }

    private void validateBirthDate(LocalDate date) {
        if (date == null || date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Invalid birth date");
    }

    private void validateCountryPhoneCode(int code) {
        if (code < 0 || String.valueOf(code).length() > 3)
            throw new IllegalArgumentException("Country phone code must be >= 0 and at most 3 digits");
    }

    private void validatePhone(long phone) {
        if (phone < 0 || String.valueOf(phone).length() > 11)
            throw new IllegalArgumentException("Phone must be >= 0 and at most 11 digits");
    }
}
