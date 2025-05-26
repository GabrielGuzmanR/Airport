package airport.infrastructure.loader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import airport.infrastructure.loader.interfaces.DataLoaderInterface;
import airport.model.Flight;
import airport.model.Location;
import airport.model.Plane;

public class FlightLoader implements DataLoaderInterface<Flight> {

    private final List<Plane> planes;
    private final List<Location> locations;

    public FlightLoader(List<Plane> planes, List<Location> locations) {
        this.planes = planes;
        this.locations = locations;
    }

    @Override
    public List<Flight> load(String filePath) throws Exception {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2)
                return flights;
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
                Plane plane = planes.stream().filter(p -> p.getId().equals(values.get("plane"))).findFirst()
                        .orElse(null);
                Location departure = locations.stream()
                        .filter(l -> l.getAirportId().equals(values.get("departureLocation"))).findFirst().orElse(null);
                Location arrival = locations.stream()
                        .filter(l -> l.getAirportId().equals(values.get("arrivalLocation"))).findFirst().orElse(null);
                Location scale = null;
                if (values.get("scaleLocation") != null && !values.get("scaleLocation").equals("null"))
                    scale = locations.stream().filter(l -> l.getAirportId().equals(values.get("scaleLocation")))
                            .findFirst().orElse(null);

                LocalDateTime departureDate = LocalDateTime.parse(values.get("departureDate"));
                int hoursArrival = Integer.parseInt(values.get("hoursDurationArrival"));
                int minsArrival = Integer.parseInt(values.get("minutesDurationArrival"));
                int hoursScale = Integer.parseInt(values.get("hoursDurationScale"));
                int minsScale = Integer.parseInt(values.get("minutesDurationScale"));

                Flight flight;
                if (scale == null) {
                    flight = new Flight(values.get("id"), plane, departure, arrival, departureDate, hoursArrival,
                            minsArrival);
                } else {
                    flight = new Flight(values.get("id"), plane, departure, scale, arrival, departureDate, hoursArrival,
                            minsArrival, hoursScale, minsScale);
                }
                flights.add(flight);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo flights: " + e.getMessage());
        }
        return flights;
    }
}
