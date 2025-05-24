package airport.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Passenger implements Cloneable {
    private final long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private int countryPhoneCode;
    private long phone;
    private String country;
    private ArrayList<Flight> flights;

    public Passenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone,
            String country) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.countryPhoneCode = countryPhoneCode;
        this.phone = phone;
        this.country = country;
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        if (flight == null)
            throw new IllegalArgumentException("Flight cannot be null");
        if (!flights.contains(flight)) {
            flights.add(flight);
        }
    }

    // Getters & setters with validation
    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getCountryPhoneCode() {
        return countryPhoneCode;
    }

    public long getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public ArrayList<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCountryPhoneCode(int countryPhoneCode) {
        this.countryPhoneCode = countryPhoneCode;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullname() {
        return firstname + " " + lastname;
    }

    public String generateFullPhone() {
        return "+" + countryPhoneCode + " " + phone;
    }

    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int getNumFlights() {
        return flights.size();
    }

    // Prototype
    @Override
    public Passenger clone() {
        try {
            Passenger copy = (Passenger) super.clone();
            // Shallow copy of flights: the list is new, but Flight objects inside are the
            // same references.
            copy.flights = new ArrayList<>(this.flights);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // equals & hashCode for checking uniqueness and flight inclusion
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Passenger))
            return false;
        Passenger that = (Passenger) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}