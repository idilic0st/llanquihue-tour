package model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int precio, Guia guiaAsignado, int numeroDeParadas) {
        super(nombre, duracionHoras, precio, guiaAsignado); // Pasa los datos comunes al padre
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() { return numeroDeParadas; }
    public void setNumeroDeParadas(int numeroDeParadas) { this.numeroDeParadas = numeroDeParadas; }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: Ruta Gastronómica | N° Paradas: " + numeroDeParadas;
    }
}