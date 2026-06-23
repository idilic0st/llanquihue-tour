package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

/**
 * Clase principal de la aplicacion Llanquihue Tour.
 * Ejecuta el recorrido automatizado y el filtrado por consola.
 */
public class Main {

    /**
     * Metodo principal que inicia la ejecucion del programa.
     *
     * @param args Argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();

        // Ruta de la carpeta del proyecto
        String ruta = "resources/tours.txt";

        System.out.println("Iniciando carga de datos...\n");
        ArrayList<Tour> tours = gestor.cargarTours(ruta);

        // Recorrido
        System.out.println("=== LISTADO GENERAL DE TOURS Y GUÍAS ===");
        for (Tour t : tours) {
            System.out.println(t);
        }

        // Busqueda automatizada
        String guiaBuscado = "Juan Perez";
        System.out.println("\n=== TOURS ASIGNADOS AL GUÍA: " + guiaBuscado + " ===");

        boolean encontrado = false;
        for (Tour t : tours) {
            if (t.getGuiaAsignado().getNombre().equalsIgnoreCase(guiaBuscado)) {
                System.out.println(t);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours para el guía especificado.");
        }
        // FILTRADO NUMÉRICO (Por Precio)
        int precioLimite = 30000;
        System.out.println("\n=== FILTRADO: Tours con precio mayor a $" + precioLimite + " ===");
        boolean hayToursCaros = false;

        for (Tour t : tours) {
            if (t.getPrecio() > precioLimite) {
                System.out.println(t);
                hayToursCaros = true;
            }
        }

        if (!hayToursCaros) {
            System.out.println("No se encontraron tours por sobre ese precio.");
        }
    }
}