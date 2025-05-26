package airport.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Flight implements Cloneable {

    private final String id;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private Location departureLocation;
    private Location scaleLocation;
    private Location arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;

    // Constructor sin escala
    public Flight(String id, Plane plane, Location departureLocation, Location arrivalLocation,
            LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        this(id, plane, departureLocation, null, arrivalLocation, departureDate, hoursDurationArrival,
                minutesDurationArrival, 0, 0);
    }

    // Constructor con escala
    public Flight(String id, Plane plane, Location departureLocation, Location scaleLocation, Location arrivalLocation,
            LocalDateTime departureDate,
            int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {

        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;

        this.plane.addFlight(this);
    }

    public void addPassenger(Passenger passenger) {
        if (passenger == null)
            throw new IllegalArgumentException("Passenger cannot be null");
        if (!passengers.contains(passenger)) {
            passengers.add(passenger);
        }
    }

    public String getId() {
        return id;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public Location getScaleLocation() {
        return scaleLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public int getHoursDurationArrival() {
        return hoursDurationArrival;
    }

    public int getMinutesDurationArrival() {
        return minutesDurationArrival;
    }

    public int getHoursDurationScale() {
        return hoursDurationScale;
    }

    public int getMinutesDurationScale() {
        return minutesDurationScale;
    }

    public Plane getPlane() {
        return plane;
    }

    public ArrayList<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public int getNumPassengers() {
        return passengers.size();
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime calculateArrivalDate() {
        return departureDate
                .plusHours(hoursDurationScale)
                .plusHours(hoursDurationArrival)
                .plusMinutes(minutesDurationScale)
                .plusMinutes(minutesDurationArrival);
    }

    public void delay(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || (hours == 0 && minutes == 0))
            throw new IllegalArgumentException("Delay time must be greater than 00:00");
        this.departureDate = this.departureDate.plusHours(hours).plusMinutes(minutes);
    }

    // Prototype Pattern
    @Override
    public Flight clone() {
        try {
            Flight copy = (Flight) super.clone();
            copy.passengers = new ArrayList<>(this.passengers);
            // Plane/Location assumed immutable or managed elsewhere
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Flight))
            return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setHoursDurationArrival(int hoursDurationArrival) {
        this.hoursDurationArrival = hoursDurationArrival;
    }

    public void setHoursDurationScale(int hoursDurationScale) {
        this.hoursDurationScale = hoursDurationScale;
    }

    public void setMinutesDurationArrival(int minutesDurationArrival) {
        this.minutesDurationArrival = minutesDurationArrival;
    }

    public void setMinutesDurationScale(int minutesDurationScale) {
        this.minutesDurationScale = minutesDurationScale;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setScaleLocation(Location scaleLocation) {
        this.scaleLocation = scaleLocation;
    }

    
}