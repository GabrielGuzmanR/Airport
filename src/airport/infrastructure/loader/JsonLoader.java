package airport.infrastructure.loader;

import airport.infrastructure.loader.interfaces.DataLoaderInterface;

import java.util.*;

public class JsonLoader {

    /**
     * Se actualiza el loader de forma que permita delegar y obtener los datos de
     * forma dinamica
     **/
    public static <T> List<T> loadModel(String filePath, DataLoaderInterface<T> loader) {
        try {

            return loader.load(filePath);
        } catch (Exception e) {
            System.out.println("Error cargando datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}