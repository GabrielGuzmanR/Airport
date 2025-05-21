package airport.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Passenger implements InterPassenger, Cloneable {
    private final long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private int countryPhoneCode;
    private long phone;
    private String country;
    private ArrayList<Flight> flights;

    public Passenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone, String country) {
        validateId(id);
        validateString(firstname, "firstname");
        validateString(lastname, "lastname");
        validateBirthDate(birthDate);
        validateCountryPhoneCode(countryPhoneCode);
        validatePhone(phone);
        validateString(country, "country");

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.countryPhoneCode = countryPhoneCode;
        this.phone = phone;
        this.country = country;
        this.flights = new ArrayList<>();
    }

    @Override
    public void addFlight(Flight flight) {
        if (flight == null) throw new IllegalArgumentException("Flight cannot be null");
        if (!flights.contains(flight)) {
            flights.add(flight);
        }
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

    // Getters & setters with validation
    @Override
    public long getId() { return id; }
    
    @Override
    public String getFirstname() { return firstname; }
    
    @Override
    public String getLastname() { return lastname; }
    
    @Override
    public LocalDate getBirthDate() { return birthDate; }
    
    @Override
    public int getCountryPhoneCode() { return countryPhoneCode; }
    
    @Override
    public long getPhone() { return phone; }
    
    @Override
    public String getCountry() { return country; }
    
    @Override
    public ArrayList<Flight> getFlights() { return new ArrayList<>(flights); }

    @Override
    public void setFirstname(String firstname) { 
        validateString(firstname, "firstname"); 
        this.firstname = firstname; 
    }
    
    @Override
    public void setLastname(String lastname) { 
        validateString(lastname, "lastname"); 
        this.lastname = lastname; 
    }
    
    @Override
    public void setBirthDate(LocalDate birthDate) { 
        validateBirthDate(birthDate); 
        this.birthDate = birthDate; 
    }
    
    @Override
    public void setCountryPhoneCode(int countryPhoneCode) { 
        validateCountryPhoneCode(countryPhoneCode); 
        this.countryPhoneCode = countryPhoneCode; 
    }
    
    @Override
    public void setPhone(long phone) { 
        validatePhone(phone); 
        this.phone = phone; 
    }
    
    @Override
    public void setCountry(String country) { 
        validateString(country, "country"); 
        this.country = country; 
    }

    @Override
    public String getFullname() { return firstname + " " + lastname; }
    
    @Override
    public String generateFullPhone() { return "+" + countryPhoneCode + " " + phone; }
    
    @Override
    public int calculateAge() { return Period.between(birthDate, LocalDate.now()).getYears(); }
    
    @Override
    public int getNumFlights() { return flights.size(); }

    // Prototype
    @Override
    public Passenger clone() {
        try {
            Passenger copy = (Passenger) super.clone();
            // Shallow copy of flights: the list is new, but Flight objects inside are the same references.
            copy.flights = new ArrayList<>(this.flights);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // equals & hashCode for checking uniqueness and flight inclusion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger that = (Passenger) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}