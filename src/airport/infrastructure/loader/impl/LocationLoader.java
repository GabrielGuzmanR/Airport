package airport.infrastructure.loader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import airport.infrastructure.loader.interfaces.DataLoaderInterface;
import airport.model.Location;

public class LocationLoader implements DataLoaderInterface<Location> {

    @Override
    public List<Location> load(String filePath) throws Exception {
        List<Location> locations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2)
                return locations;
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
                        Double.parseDouble(values.get("airportLongitude")));
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo locations: " + e.getMessage());
        }
        return locations;
    }
}
