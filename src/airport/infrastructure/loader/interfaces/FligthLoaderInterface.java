package airport.infrastructure.loader.interfaces;

import java.util.List;

public interface FligthLoaderInterface<T, P, L> {
    List<T> load(String filePath, List<P> planes, List<L> locations) throws Exception;
}