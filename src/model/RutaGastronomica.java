package model;

/**
 * Servicio turístico enfocado en experiencias culinarias.
 */
public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int precio, Guia guiaAsignado, int numeroDeParadas) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() { return numeroDeParadas; }

    @Override
    public String mostrarResumen() {
        String infoGuia = (guiaAsignado != null) ? guiaAsignado.toString() : "Sin Guía Asignado";
        return "Ruta Gastronómica: " + getNombre() + " | Duración: " + getDuracionHoras() + "h | Precio: $" + getPrecio() + " | Paradas: " + numeroDeParadas + " | " + infoGuia;
    }
}