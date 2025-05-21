/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package airport.model;

import java.util.List;

/**
 *
 * @author aleja
 */
public interface InterPlane {
    String getId();
    String getModel();
    String getAirline();
    int getCapacity();
    List<Flight> getFlights();
    
    void addFlight(Flight flight);
    
    Object clone() throws CloneNotSupportedException;
}
































