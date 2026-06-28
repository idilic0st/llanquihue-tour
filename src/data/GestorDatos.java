package data;

import model.*;
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
     * Lee archivo TXT.
     *
     * @param rutaArchivo La ruta donde se encuentra el archivo .txt.
     * @return Un ArrayList dinámico que contiene los servicios turísticos (subclases) cargados.
     */
    public ArrayList<ServicioTuristico> cargarTours(String rutaArchivo) {
        ArrayList<ServicioTuristico> listaTours = new ArrayList<>();

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
                    String tipo = datos[1]; // Evaluamos la columna del TXT
                    int precio = Integer.parseInt(datos[2]); // Lanza NumberFormatException si falla

                    String rutGuia = datos[3];
                    String nombreGuia = datos[4];
                    String especialidad = datos[5];

                    // EXCEPCIÓN: Validar que campos críticos no estén vacíos
                    if (rutGuia.trim().isEmpty() || nombreGuia.trim().isEmpty()) {
                        throw new Exception("Datos del guía faltantes.");
                    }

                    Guia nuevoGuia = new Guia(rutGuia, nombreGuia, especialidad);

                    // duración estimada
                    int duracionEstimada = 3;

                    ServicioTuristico nuevoServicio;

                    // INTERPRETACIÓN DEL TXT: Según el tipo en el archivo, instanciamos la subclase específica
                    if (tipo.equalsIgnoreCase("Gastrononico") || tipo.equalsIgnoreCase("Gastronomico") || tipo.equalsIgnoreCase("Gastronomica")) {
                        nuevoServicio = new RutaGastronomica(nombreTour, duracionEstimada, precio, nuevoGuia, 4); // 4 paradas por defecto
                    } else if (tipo.equalsIgnoreCase("Lacustre")) {
                        nuevoServicio = new PaseoLacustre(nombreTour, duracionEstimada, precio, nuevoGuia, "Catamarán");
                    } else {
                        // Cualquier otro tipo (ej: Cultural o Historico) se crea como Excursión Cultural
                        nuevoServicio = new ExcursionCultural(nombreTour, duracionEstimada, precio, nuevoGuia, "Casco Histórico");
                    }

                    listaTours.add(nuevoServicio);

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