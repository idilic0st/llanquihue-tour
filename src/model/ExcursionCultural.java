package model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, int precio, Guia guiaAsignado, String lugarHistorico) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() { return lugarHistorico; }

    @Override
    public String mostrarResumen() {
        String infoGuia = (guiaAsignado != null) ? guiaAsignado.toString() : "Sin Guía Asignado";
        return "Excursión Cultural: " + getNombre() + " | Duración: " + getDuracionHoras() + "h | Precio: $" + getPrecio() + " | Lugar: " + lugarHistorico + " | " + infoGuia;
    }
}