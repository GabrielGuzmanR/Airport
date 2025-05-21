package airport.model;

import java.util.Objects;

public class Location implements InterLocation, Cloneable {
    private final String airportId;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private double airportLatitude;
    private double airportLongitude;

    public Location(String airportId, String airportName, String airportCity, String airportCountry, double airportLatitude, double airportLongitude) {
        validateId(airportId);
        validateString(airportName, "name");
        validateString(airportCity, "city");
        validateString(airportCountry, "country");
        validateLatitude(airportLatitude);
        validateLongitude(airportLongitude);

        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportLatitude = airportLatitude;
        this.airportLongitude = airportLongitude;
    }

    private void validateId(String id) {
        if (id == null || !id.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Airport id must be exactly 3 uppercase letters");
        }
    }

    private void validateString(String s, String field) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport " + field + " cannot be empty");
        }
    }

    private void validateLatitude(double lat) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Airport latitude must be in range [-90, 90]");
        }
        if (String.valueOf(Math.abs(lat)).contains(".") && String.valueOf(lat).split("\\.")[1].length() > 4) {
            throw new IllegalArgumentException("Airport latitude must have at most 4 decimal places");
        }
    }

    private void validateLongitude(double lon) {
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Airport longitude must be in range [-180, 180]");
        }
        if (String.valueOf(Math.abs(lon)).contains(".") && String.valueOf(lon).split("\\.")[1].length() > 4) {
            throw new IllegalArgumentException("Airport longitude must have at most 4 decimal places");
        }
    }

    @Override
    public String getAirportId() { return airportId; }
    
    @Override
    public String getAirportName() { return airportName; }
    
    @Override
    public String getAirportCity() { return airportCity; }
    
    @Override
    public String getAirportCountry() { return airportCountry; }
    
    @Override
    public double getAirportLatitude() { return airportLatitude; }
    
    @Override
    public double getAirportLongitude() { return airportLongitude; }
    
    @Override
    public void setAirportName(String name) { 
        validateString(name, "name"); 
        this.airportName = name; 
    }
    
    @Override
    public void setAirportCity(String city) { 
        validateString(city, "city"); 
        this.airportCity = city; 
    }
    
    @Override
    public void setAirportCountry(String country) { 
        validateString(country, "country"); 
        this.airportCountry = country; 
    }
    
    @Override
    public void setAirportLatitude(double lat) { 
        validateLatitude(lat); 
        this.airportLatitude = lat; 
    }
    
    @Override
    public void setAirportLongitude(double lon) { 
        validateLongitude(lon); 
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
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return airportId.equals(location.airportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId);
    }
}