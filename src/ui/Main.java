package ui;

import data.GestorServicios;
import model.ServicioTuristico;
import java.util.List;

/**
 * Clase principal de inicio de la aplicación Llanquihue Tour.
 * Ejecuta el recorrido de colecciones demostrando el uso de polimorfismo dinámico
 * e integra los filtros de búsqueda y segmentación de precios.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicación Llanquihue Tour - Sistema de Gestión");
        System.out.println("Cargando servicios turísticos desde la colección genérica...\n");

        // Instancia del gestor que inicializa la colección de datos de prueba
        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.obtenerServicios();

        // 1. RECORRIDO GENERAL POLIMÓRFICO
        System.out.println("=== LISTADO GENERAL DE SERVICIOS TURÍSTICOS (POLIMORFISMO EN ACCIÓN) ===");
        for (ServicioTuristico servicio : servicios) {
            // ejecuta el metodo mostrarInformacion() sobrescrito en cada subclase
            servicio.mostrarInformacion();
        }

        // 2. BÚSQUEDA AUTOMATIZADA POR GUÍA
        String guiaBuscado = "Juan Pérez";
        System.out.println("\n=== TOURS ASIGNADOS AL GUÍA: " + guiaBuscado + " ===");

        boolean encontrado = false;
        for (ServicioTuristico servicio : servicios) {
            // Se accede al objeto Guia mediante composición y se compara el nombre
            if (servicio.getGuiaAsignado().getNombre().equalsIgnoreCase(guiaBuscado)) {
                servicio.mostrarInformacion(); // Muestra la información de forma polimórfica
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours para el guía especificado.");
        }

        // 3. FILTRADO NUMÉRICO (Por Umbral de Precio)
        int precioLimite = 30000;
        System.out.println("\n=== FILTRADO: Tours con precio mayor a $" + precioLimite + " ===");

        boolean hayToursCaros = false;
        for (ServicioTuristico servicio : servicios) {
            // Se evalúa el precio común heredado de la superclase
            if (servicio.getPrecio() > precioLimite) {
                servicio.mostrarInformacion(); // Muestra la información de forma polimórfica
                hayToursCaros = true;
            }
        }

        if (!hayToursCaros) {
            System.out.println("No se encontraron tours por sobre ese precio.");
        }

        System.out.println("\nProceso de visualización y filtrado finalizado con éxito.");
    }
}