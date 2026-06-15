package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    //Arraylist
    public static ArrayList<Tour> leerToursDesdeArchivo(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        // Uso de try-with-resources para asegurar el cierre del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leer línea por línea hasta el final del archivo
            while ((linea = br.readLine()) != null) {
                // Saltar líneas vacías si existieran
                if (linea.trim().isEmpty()) continue;

                // Separar los datos por punto y coma
                String[] datos = linea.split(";");

                // Extraer variables y parsear el precio a entero
                String nombre = datos[0];
                String tipo = datos[1];
                int precio = Integer.parseInt(datos[2]);

                // Instanciar el objeto
                Tour nuevoTour = new Tour(nombre, tipo, precio);
                listaTours.add(nuevoTour);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico del archivo: " + e.getMessage());
        }

        return listaTours;
    }
}
