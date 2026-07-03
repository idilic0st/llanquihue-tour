package data;

import model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la gestión y almacenamiento de servicios turísticos.
 * Implementa una colección genérica para administrar de forma centralizada las instancias.
 */
public class GestorServicios {
    private List<ServicioTuristico> listaServicios;

    public GestorServicios() {
        this.listaServicios = new ArrayList<>();
        cargarInstanciasPrueba();
    }

    /**
     * Instancia y añade al menos cinco objetos combinando las distintas subclases.
     */
    private void cargarInstanciasPrueba() {
        Guia guia1 = new Guia("15443221-K", "Ana María López", "Gastronomía");
        Guia guia2 = new Guia("18765432-1", "Carlos Plaza", "Navegación");
        Guia guia3 = new Guia("12345678-9", "Juan Pérez", "Historia");

        // Carga de 5 objetos de prueba combinando subclases
        listaServicios.add(new RutaGastronomica("Kuchen Tour Frutillar", 3, 25000, guia1, 4));
        listaServicios.add(new PaseoLacustre("Vuelta al Lago Llanquihue", 4, 45000, guia2, "Catamarán"));
        listaServicios.add(new ExcursionCultural("Teatro del Lago e Historia", 2, 15000, guia3, "Frutillar Bajo"));
        listaServicios.add(new RutaGastronomica("Sabores de Puerto Varas", 3, 35000, guia1, 5));
        listaServicios.add(new PaseoLacustre("Navegación Isla de los Pájaros", 2, 30000, guia2, "Lancha"));
    }

    /**
     * Obtiene la colección polimórfica de servicios turísticos.
     * @return List de ServicioTuristico.
     */
    public List<ServicioTuristico> obtenerServicios() {
        return listaServicios;
    }
}
