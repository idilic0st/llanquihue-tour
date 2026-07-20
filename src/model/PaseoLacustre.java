package model;

/**
 * Servicio turístico enfocado en rutas navegables.
 */
public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, int precio, Guia guiaAsignado, String tipoEmbarcacion) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() { return tipoEmbarcacion; }

    @Override
    public String mostrarResumen() {
        String infoGuia = (guiaAsignado != null) ? guiaAsignado.toString() : "Sin Guía Asignado";
        return "Paseo Lacustre: " + getNombre() + " | Duración: " + getDuracionHoras() + "h | Precio: $" + getPrecio() + " | Embarcación: " + tipoEmbarcacion + " | " + infoGuia;
    }
}