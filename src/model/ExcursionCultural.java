package model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, int precio, Guia guiaAsignado, String lugarHistorico) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() { return lugarHistorico; }
    public void setLugarHistorico(String lugarHistorico) { this.lugarHistorico = lugarHistorico; }

    @Override
    public void mostrarInformacion() {
        System.out.println(super.toString() + " | Categoría: Excursión Cultural | Lugar: " + lugarHistorico);
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: Excursión Cultural | Lugar: " + lugarHistorico;
    }
}