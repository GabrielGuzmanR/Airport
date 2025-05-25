package airport.service.validator.interfaces;

/** Interfaz generíca, para la validación de los datos de los modelos **/
public interface ValidatorInterface<T> {

    void validate(T model);
}
