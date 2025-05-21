/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package airport.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface InterPassenger {
    long getId();
    String getFirstname();
    String getLastname();
    LocalDate getBirthDate();
    int getCountryPhoneCode();
    long getPhone();
    String getCountry();
    List<Flight> getFlights();
    
    void setFirstname(String firstname);
    void setLastname(String lastname);
    void setBirthDate(LocalDate birthDate);
    void setCountryPhoneCode(int countryPhoneCode);
    void setPhone(long phone);
    void setCountry(String country);
    
    void addFlight(Flight flight);
    String getFullname();
    String generateFullPhone();
    int calculateAge();
    int getNumFlights();
    
    Passenger clone();
}
