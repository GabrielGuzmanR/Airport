package airport.service.loader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import airport.model.Passenger;
import airport.service.loader.interfaces.DataLoaderInterface;

public class PassengerLoader implements DataLoaderInterface {

    @Override
    public List<Passenger> load(String filePath) throws Exception {
        List<Passenger> passengers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2)
                return passengers;
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
                        values.get("country"));
                passengers.add(passenger);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo passengers: " + e.getMessage());
        }
        return passengers;
    }
}
