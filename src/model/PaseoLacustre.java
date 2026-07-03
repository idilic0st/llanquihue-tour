package model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, int precio, Guia guiaAsignado, String tipoEmbarcacion) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() { return tipoEmbarcacion; }
    public void setTipoEmbarcacion(String tipoEmbarcacion) { this.tipoEmbarcacion = tipoEmbarcacion; }

    @Override
    public void mostrarInformacion() {
        System.out.println(super.toString() + " | Categoría: Paseo Lacustre | Embarcación: " + tipoEmbarcacion);
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: Paseo Lacustre | Embarcación: " + tipoEmbarcacion;
    }
}