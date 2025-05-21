package airport.utils;

import airport.model.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class JsonLoader {

    public static List<Plane> loadPlanes(String filePath) {
        List<Plane> planes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2) return planes;
            content = content.substring(1, content.length() - 1);
            String[] objects = content.split("\\},\\{");
            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "");
                Map<String, String> values = new HashMap<>();
                for (String pair : obj.split(",")) {
                    String[] kv = pair.split(":", 2);
                    if (kv.length == 2) {
                        String key = kv[0].replace("\"", "").trim();
                        String value = kv[1].replace("\"", "").trim();
                        values.put(key, value);
                    }
                }
                Plane plane = new Plane(
                        values.get("id"),
                        values.get("brand"),
                        values.get("model"),
                        Integer.parseInt(values.get("maxCapacity")),
                        values.get("airline")
                );
                planes.add(plane);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo planes: " + e.getMessage());
        }
        return planes;
    }

    public static List<Location> loadLocations(String filePath) {
        List<Location> locations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2) return locations;
            content = content.substring(1, content.length() - 1);
            String[] objects = content.split("\\},\\{");
            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "");
                Map<String, String> values = new HashMap<>();
                for (String pair : obj.split(",")) {
                    String[] kv = pair.split(":", 2);
                    if (kv.length == 2) {
                        String key = kv[0].replace("\"", "").trim();
                        String value = kv[1].replace("\"", "").trim();
                        values.put(key, value);
                    }
                }
                Location location = new Location(
                        values.get("airportId"),
                        values.get("airportName"),
                        values.get("airportCity"),
                        values.get("airportCountry"),
                        Double.parseDouble(values.get("airportLatitude")),
                        Double.parseDouble(values.get("airportLongitude"))
                );
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo locations: " + e.getMessage());
        }
        return locations;
    }

    public static List<Passenger> loadPassengers(String filePath) {
        List<Passenger> passengers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2) return passengers;
            content = content.substring(1, content.length() - 1);
            String[] objects = content.split("\\},\\{");
            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "");
                Map<String, String> values = new HashMap<>();
                for (String pair : obj.split(",")) {
                    String[] kv = pair.split(":", 2);
                    if (kv.length == 2) {
                        String key = kv[0].replace("\"", "").trim();
                        String value = kv[1].replace("\"", "").trim();
                        values.put(key, value);
                    }
                }
                Passenger passenger = new Passenger(
                        Long.parseLong(values.get("id")),
                        values.get("firstname"),
                        values.get("lastname"),
                        LocalDate.parse(values.get("birthDate")),
                        Integer.parseInt(values.get("countryPhoneCode")),
                        Long.parseLong(values.get("phone")),
                        values.get("country")
                );
                passengers.add(passenger);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo passengers: " + e.getMessage());
        }
        return passengers;
    }

    // Para Flight necesitas pasar las listas de planes y locations ya cargadas
    public static List<Flight> loadFlights(String filePath, List<Plane> planes, List<Location> locations) {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2) return flights;
            content = content.substring(1, content.length() - 1);
            String[] objects = content.split("\\},\\{");
            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "");
                Map<String, String> values = new HashMap<>();
                for (String pair : obj.split(",")) {
                    String[] kv = pair.split(":", 2);
                    if (kv.length == 2) {
                        String key = kv[0].replace("\"", "").trim();
                        String value = kv[1].replace("\"", "").trim();
                        values.put(key, value);
                    }
                }
                // Buscamos referencias a Plane y Locations
                Plane plane = planes.stream().filter(p -> p.getId().equals(values.get("plane"))).findFirst().orElse(null);
                Location departure = locations.stream().filter(l -> l.getAirportId().equals(values.get("departureLocation"))).findFirst().orElse(null);
                Location arrival = locations.stream().filter(l -> l.getAirportId().equals(values.get("arrivalLocation"))).findFirst().orElse(null);
                Location scale = null;
                if (values.get("scaleLocation") != null && !values.get("scaleLocation").equals("null"))
                    scale = locations.stream().filter(l -> l.getAirportId().equals(values.get("scaleLocation"))).findFirst().orElse(null);

                LocalDateTime departureDate = LocalDateTime.parse(values.get("departureDate"));
                int hoursArrival = Integer.parseInt(values.get("hoursDurationArrival"));
                int minsArrival = Integer.parseInt(values.get("minutesDurationArrival"));
                int hoursScale = Integer.parseInt(values.get("hoursDurationScale"));
                int minsScale = Integer.parseInt(values.get("minutesDurationScale"));

                Flight flight;
                if (scale == null) {
                    flight = new Flight(values.get("id"), plane, departure, arrival, departureDate, hoursArrival, minsArrival);
                } else {
                    flight = new Flight(values.get("id"), plane, departure, scale, arrival, departureDate, hoursArrival, minsArrival, hoursScale, minsScale);
                }
                flights.add(flight);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo flights: " + e.getMessage());
        }
        return flights;
    }
}