package exception;

/**
 * Excepción personalizada encargada de gestionar los errores de validación
 * en el formato del RUT de los guías de turismo.
 *
 * @author David Medina
 * @version 1.0
 */
public class RutInvalidoException extends Exception {

    /**
     * Construye una nueva excepción con un mensaje de error detallado.
     *
     * @param mensaje Texto explicativo del motivo del fallo.
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}