package ui;

import data.GestorDatos;
import model.ServicioTuristico;
import java.util.ArrayList;

/**
 * Clase principal de la aplicacion Llanquihue Tour.
 * Ejecuta el recorrido automatizado y el filtrado por consola utilizando el archivo estructurado.
 */
public class Main {

    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();

        // Ruta de la carpeta del proyecto
        String ruta = "resources/tours.txt";

        System.out.println("Iniciando carga de datos desde archivo .txt...\n");
        // Ahora cargamos la lista usando la superclase que contiene las subclases dinámicas
        ArrayList<ServicioTuristico> tours = gestor.cargarTours(ruta);

        // Recorrido
        System.out.println("=== LISTADO GENERAL DE TOURS Y GUÍAS (DESDE TXT) ===");
        for (ServicioTuristico t : tours) {
            System.out.println(t); // Invoca el toString() específico de la subclase creada
        }

        // Busqueda automatizada
        String guiaBuscado = "Juan Perez";
        System.out.println("\n=== TOURS ASIGNADOS AL GUÍA: " + guiaBuscado + " ===");

        boolean encontrado = false;
        for (ServicioTuristico t : tours) {
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

        for (ServicioTuristico t : tours) {
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