package airport.infrastructure.loader.interfaces;

import java.util.List;

public interface DataLoaderInterface<T> {
    List<T> load(String filePath) throws Exception;
}