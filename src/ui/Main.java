package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String ruta = "resources/tours.txt";

        ArrayList<Tour> todosLosTours = GestorDatos.leerToursDesdeArchivo(ruta);

        System.out.println("=== RECORRIDO: LISTA COMPLETA DE TOURS ===");
        if (todosLosTours.isEmpty()) {
            System.out.println("No se cargaron tours. Verifica la ubicación del archivo.");
        } else {
            for (Tour t : todosLosTours) {
                System.out.println(t);
            }
        }
        System.out.println();

        // FILTRADO 1 por tipo
        String tipoFiltro = "Gastronomico";
        System.out.println("=== FILTRADO: Tours de tipo '" + tipoFiltro + "' ===");
        for (Tour t : todosLosTours) {
            if (t.getTipo().equalsIgnoreCase(tipoFiltro)) {
                System.out.println(t);
            }
        }
        System.out.println();

        // FILTRADO 2: Filtrar por precio
        int precioLimite = 30000;
        System.out.println("=== FILTRADO: Tours con precio mayor a $" + precioLimite + " ===");
        for (Tour t : todosLosTours) {
            if (t.getPrecio() > precioLimite) {
                System.out.println(t);
            }
        }
    }
}