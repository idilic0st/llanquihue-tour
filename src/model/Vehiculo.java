package model;

public class Vehiculo implements Registrable {
    private String patente;
    private String modelo;
    private int capacidad;

    public Vehiculo(String patente, String modelo, int capacidad) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getPatente() { return patente; }
    public String getModelo() { return modelo; }
    public int getCapacidad() { return capacidad; }

    @Override
    public String mostrarResumen() {
        return "Vehículo - Patente: " + patente + " | Modelo: " + modelo + " | Capacidad: " + capacidad + " pasajeros";
    }
}