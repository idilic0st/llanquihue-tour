package data;

import model.Registrable;
import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private List<Registrable> listaEntidades;

    public GestorEntidades() {
        this.listaEntidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        this.listaEntidades.add(entidad);
    }

    public List<Registrable> getListaEntidades() {
        return listaEntidades;
    }

    /**
     * Clasifica y ordena dinámicamente las entidades por su tipo real
     * utilizando instanceof, estructurando un reporte limpio y agrupado.
     */
    public String generarReporteDiferenciado() {
        StringBuilder sb = new StringBuilder();

        // Listas auxiliares para ordenar el reporte
        List<model.ServicioTuristico> servicios = new ArrayList<>();
        List<model.Guia> guias = new ArrayList<>();
        List<model.Vehiculo> vehiculos = new ArrayList<>();
        List<model.ColaboradorExterno> colaboradores = new ArrayList<>();

        // Clasificación sistemática en tiempo de ejecución
        for (Registrable entidad : listaEntidades) {
            if (entidad instanceof model.ServicioTuristico) {
                servicios.add((model.ServicioTuristico) entidad);
            } else if (entidad instanceof model.Guia) {
                guias.add((model.Guia) entidad);
            } else if (entidad instanceof model.Vehiculo) {
                vehiculos.add((model.Vehiculo) entidad);
            } else if (entidad instanceof model.ColaboradorExterno) {
                colaboradores.add((model.ColaboradorExterno) entidad);
            }
        }

        // Construcción visual del reporte estructurado
        sb.append("=========================================================\n");
        sb.append("             SISTEMA DE CONTROL - LLANQUIHUE TOUR        \n");
        sb.append("=========================================================\n\n");

        sb.append("--- [1] SERVICIOS TURÍSTICOS ACTIVOS ---\n");
        if (servicios.isEmpty()) {
            sb.append(" * No hay servicios turísticos registrados actualmente.\n");
        } else {
            for (model.ServicioTuristico s : servicios) {
                sb.append(" * ").append(s.mostrarResumen()).append("\n");
            }
        }
        sb.append("\n");

        sb.append("--- [2] PERSONAL / GUÍAS REGISTRADOS ---\n");
        if (guias.isEmpty()) {
            sb.append(" * No hay personal de guiado registrado.\n");
        } else {
            for (model.Guia g : guias) {
                sb.append(" * ").append(g.mostrarResumen()).append("\n");
            }
        }
        sb.append("\n");

        sb.append("--- [3] LOGÍSTICA / FLOTA DE VEHÍCULOS ---\n");
        if (vehiculos.isEmpty()) {
            sb.append(" * No hay vehículos asignados en la flota.\n");
        } else {
            for (model.Vehiculo v : vehiculos) {
                sb.append(" * ").append(v.mostrarResumen()).append("\n");
            }
        }
        sb.append("\n");

        sb.append("--- [4] ASOCIACIONES Y COLABORADORES EXTERNOS ---\n");
        if (colaboradores.isEmpty()) {
            sb.append(" * No hay prestadores externos registrados.\n");
        } else {
            for (model.ColaboradorExterno c : colaboradores) {
                sb.append(" * ").append(c.mostrarResumen()).append("\n");
            }
        }
        sb.append("\n");

        sb.append("=========================================================\n");
        sb.append("                   MÉTRICAS DEL SISTEMA                  \n");
        sb.append("=========================================================\n");
        sb.append(" Servicios Turísticos: ").append(servicios.size()).append("\n");
        sb.append(" Guías de Turismo:     ").append(guias.size()).append("\n");
        sb.append(" Vehículos en Flota:   ").append(vehiculos.size()).append("\n");
        sb.append(" Socios Externos:      ").append(colaboradores.size()).append("\n");
        sb.append(" Total de Registros:   ").append(listaEntidades.size()).append("\n");
        sb.append("=========================================================\n");

        return sb.toString();
    }
}