package data;

import model.Guia;
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gestor encargado de la manipulación y carga de datos externos.
 * Aplica try-catch para asegurar la integridad de la ejecución.
 */
public class GestorDatos {

    /**
     * Lee un archivo de texto plano y transforma cada línea en un objeto Tour con su respectivo Guia.
     *
     * @param rutaArchivo La ruta donde se encuentra el archivo .txt.
     * @return Un ArrayList dinámico que contiene todos los tours cargados exitosamente.
     */
    public ArrayList<Tour> cargarTours(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");

                try {
                    // EXCEPCIÓN: Validar que la línea tenga exactamente los 6 datos esperados
                    if (datos.length < 6) {
                        throw new Exception("Línea incompleta, faltan datos.");
                    }

                    String nombreTour = datos[0];
                    String tipo = datos[1];
                    int precio = Integer.parseInt(datos[2]); // Lanza NumberFormatException si falla

                    String rutGuia = datos[3];
                    String nombreGuia = datos[4];
                    String especialidad = datos[5];

                    // EXCEPCIÓN: Validar que campos críticos no estén vacíos
                    if (rutGuia.trim().isEmpty() || nombreGuia.trim().isEmpty()) {
                        throw new Exception("Datos del guía faltantes.");
                    }

                    Guia nuevoGuia = new Guia(rutGuia, nombreGuia, especialidad);
                    Tour nuevoTour = new Tour(nombreTour, tipo, precio, nuevoGuia);

                    listaTours.add(nuevoTour);

                } catch (NumberFormatException e) {
                    System.out.println("Error: El precio no es un número válido en la línea: " + linea);
                } catch (Exception e) {
                    System.out.println("Error de formato en línea [" + linea + "]: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error crítico: No se pudo abrir el archivo. " + e.getMessage());
        }
        return listaTours;
    }
}
