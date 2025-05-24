package airport.model;

import java.util.Objects;

public class Location implements Cloneable {
    private final String airportId;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private double airportLatitude;
    private double airportLongitude;

    public Location(String airportId, String airportName, String airportCity, String airportCountry,
            double airportLatitude, double airportLongitude) {

        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportLatitude = airportLatitude;
        this.airportLongitude = airportLongitude;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public double getAirportLatitude() {
        return airportLatitude;
    }

    public double getAirportLongitude() {
        return airportLongitude;
    }

    public void setAirportName(String name) {
        this.airportName = name;
    }

    public void setAirportCity(String city) {
        this.airportCity = city;
    }

    public void setAirportCountry(String country) {
        this.airportCountry = country;
    }

    public void setAirportLatitude(double lat) {
        this.airportLatitude = lat;
    }

    public void setAirportLongitude(double lon) {
        this.airportLongitude = lon;
    }

    // Prototype Pattern
    @Override
    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // For uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Location))
            return false;
        Location location = (Location) o;
        return airportId.equals(location.airportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId);
    }
}