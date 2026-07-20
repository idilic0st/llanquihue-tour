package data;

import model.*;
import exception.RutInvalidoException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {

    private static final String CARPETA = "resources";
    private static final String RUTA_ARCHIVO = CARPETA + "/datos_agencia.txt";

    private static void verificarDirectorio() {
        try {
            File directorio = new File(CARPETA);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar el archivo de datos: " + e.getMessage());
        }
    }

    public static void guardarTodo(List<Registrable> lista) {
        verificarDirectorio();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, false))) {
            for (Registrable entidad : lista) {
                if (entidad instanceof Guia) {
                    Guia g = (Guia) entidad;
                    bw.write("GUIA;" + g.getRut() + ";" + g.getNombre() + ";" + g.getEspecialidad());
                } else if (entidad instanceof Vehiculo) {
                    Vehiculo v = (Vehiculo) entidad;
                    bw.write("VEHICULO;" + v.getPatente() + ";" + v.getModelo() + ";" + v.getCapacidad());
                } else if (entidad instanceof ColaboradorExterno) {
                    ColaboradorExterno c = (ColaboradorExterno) entidad;
                    bw.write("COLABORADOR;" + c.getNombre() + ";" + c.getRubro() + ";" + c.getTarifaConvenio());
                } else if (entidad instanceof RutaGastronomica) {
                    RutaGastronomica rg = (RutaGastronomica) entidad;
                    String rutGuia = (rg.getGuiaAsignado() != null) ? rg.getGuiaAsignado().getRut() : "NULL";
                    bw.write("RUTA_GASTRO;" + rg.getNombre() + ";" + rg.getDuracionHoras() + ";" + rg.getPrecio() + ";" + rutGuia + ";" + rg.getNumeroDeParadas());
                } else if (entidad instanceof PaseoLacustre) {
                    PaseoLacustre pl = (PaseoLacustre) entidad;
                    String rutGuia = (pl.getGuiaAsignado() != null) ? pl.getGuiaAsignado().getRut() : "NULL";
                    bw.write("PASEO_LACUSTRE;" + pl.getNombre() + ";" + pl.getDuracionHoras() + ";" + pl.getPrecio() + ";" + rutGuia + ";" + pl.getTipoEmbarcacion());
                } else if (entidad instanceof ExcursionCultural) {
                    ExcursionCultural ec = (ExcursionCultural) entidad;
                    String rutGuia = (ec.getGuiaAsignado() != null) ? ec.getGuiaAsignado().getRut() : "NULL";
                    bw.write("EXCURSION_CULT;" + ec.getNombre() + ";" + ec.getDuracionHoras() + ";" + ec.getPrecio() + ";" + rutGuia + ";" + ec.getLugarHistorico());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al sobreescribir el archivo de datos: " + e.getMessage());
        }
    }

    public static List<Registrable> leerDesdeArchivo() {
        verificarDirectorio();
        List<Registrable> resultado = new ArrayList<>();
        List<Guia> guiasTemporales = new ArrayList<>();

        // Primera Pasada: Guias, Vehiculos y Colaboradores
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length < 2) continue;

                if (datos[0].equals("GUIA")) {
                    try {
                        Guia g = new Guia(datos[1], datos[2], datos[3]);
                        guiasTemporales.add(g);
                        resultado.add(g);
                    } catch (RutInvalidoException ignored) {}
                } else if (datos[0].equals("VEHICULO")) {
                    resultado.add(new Vehiculo(datos[1], datos[2], Integer.parseInt(datos[3])));
                } else if (datos[0].equals("COLABORADOR")) {
                    resultado.add(new ColaboradorExterno(datos[1], datos[2], Integer.parseInt(datos[3])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error en la primera pasada de lectura: " + e.getMessage());
        }

        // Segunda Pasada: Servicios vinculados a sus Guias
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length < 6) continue;

                if (datos[0].equals("RUTA_GASTRO") || datos[0].equals("PASEO_LACUSTRE") || datos[0].equals("EXCURSION_CULT")) {
                    String nombre = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    int precio = Integer.parseInt(datos[3]);
                    String rutGuia = datos[4];
                    String atributoEspecif = datos[5];

                    Guia guiaAsignado = null;
                    for (Guia g : guiasTemporales) {
                        if (g.getRut().equalsIgnoreCase(rutGuia)) {
                            guiaAsignado = g;
                            break;
                        }
                    }

                    if (datos[0].equals("RUTA_GASTRO")) {
                        resultado.add(new RutaGastronomica(nombre, duracion, precio, guiaAsignado, Integer.parseInt(atributoEspecif)));
                    } else if (datos[0].equals("PASEO_LACUSTRE")) {
                        resultado.add(new PaseoLacustre(nombre, duracion, precio, guiaAsignado, atributoEspecif));
                    } else if (datos[0].equals("EXCURSION_CULT")) {
                        resultado.add(new ExcursionCultural(nombre, duracion, precio, guiaAsignado, atributoEspecif));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en la segunda pasada de lectura: " + e.getMessage());
        }

        return resultado;
    }
}