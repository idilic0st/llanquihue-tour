package model;

/**
 * Interfaz que define el contrato común de comportamiento
 * para las entidades gestionables de la agencia Llanquihue Tour.
 *
 * @author David Medina
 * @version 1.0
 */
public interface Registrable {

    /**
     * Metodo abstracto obligatorio para la visualización resumida de los datos.
     *
     * @return Una cadena de caracteres formateada con los datos de la entidad.
     */
    String mostrarResumen();
}