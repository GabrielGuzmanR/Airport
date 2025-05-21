/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package airport.model;

/**
 *
 * @author aleja
 */
public interface InterLocation {
    String getAirportId();
    String getAirportName();
    String getAirportCity();
    String getAirportCountry();
    double getAirportLatitude();
    double getAirportLongitude();
    
    void setAirportName(String name);
    void setAirportCity(String city);
    void setAirportCountry(String country);
    void setAirportLatitude(double latitude);
    void setAirportLongitude(double longitude);
    
    Location clone();
}
