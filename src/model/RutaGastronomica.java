package model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int precio, Guia guiaAsignado, int numeroDeParadas) {
        super(nombre, duracionHoras, precio, guiaAsignado);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() { return numeroDeParadas; }
    public void setNumeroDeParadas(int numeroDeParadas) { this.numeroDeParadas = numeroDeParadas; }

    @Override
    public void mostrarInformacion() {
        System.out.println(super.toString() + " | Categoría: Ruta Gastronómica | N° Paradas: " + numeroDeParadas);
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: Ruta Gastronómica | N° Paradas: " + numeroDeParadas;
    }
}