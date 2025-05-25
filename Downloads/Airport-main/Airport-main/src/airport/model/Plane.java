package airport.model;

import java.util.ArrayList;
import java.util.Objects;

public class Plane implements Cloneable {

    private final String id;
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private ArrayList<Flight> flights;

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public ArrayList<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public int getNumFlights() {
        return flights.size();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void addFlight(Flight flight) {
        if (flight == null)
            throw new IllegalArgumentException("Flight cannot be null");
        if (!flights.contains(flight)) {
            flights.add(flight);
        }
    }

    // Prototype Pattern: shallow copy of flights list
    @Override
    public Plane clone() {
        try {
            Plane copy = (Plane) super.clone();
            copy.flights = new ArrayList<>(this.flights); // shallow copy; flights inside are the same references
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // equals & hashCode for inclusion and uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Plane))
            return false;
        Plane plane = (Plane) o;
        return id.equals(plane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}