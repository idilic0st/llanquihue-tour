package model;

/**
 * Representa a un guia turistico de la agencia Llanquihue Tour.
 * Esta clase se utiliza como parte de la composicion dentro de la clase Tour.
 */
public class Guia {
    private String rut;
    private String nombre;
    private String especialidad;

    /**
     * Constructor de la clase Guia.
     *
     * @param rut          RUT del guía turístico.
     * @param nombre       Nombre completo del guía.
     * @param especialidad Especialidad del guía (ej. Aventura, Historiador).
     */
    public Guia(String rut, String nombre, String especialidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return "Guía: " + nombre + " | RUT: " + rut + " | Especialidad: " + especialidad;
    }
}