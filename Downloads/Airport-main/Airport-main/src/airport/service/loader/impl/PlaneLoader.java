package airport.service.loader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import airport.model.Plane;
import airport.service.loader.interfaces.DataLoaderInterface;

public class PlaneLoader implements DataLoaderInterface {

    public List<Plane> load(String filePath) throws Exception {

        List<Plane> planes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                json.append(line.trim());
            String content = json.toString();
            if (content.length() < 2)
                return planes;
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
                        values.get("airline"));
                planes.add(plane);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo planes: " + e.getMessage());
        }
        return planes;
    }
}
