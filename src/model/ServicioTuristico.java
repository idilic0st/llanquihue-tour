package model;

/**
 * Superclase que representa un servicio turístico genérico.
 * Aplica composición al incluir un objeto de tipo Guia.
 */
public class ServicioTuristico {
    protected String nombre;
    protected int duracionHoras;
    protected int precio;
    protected Guia guiaAsignado;

    public ServicioTuristico(String nombre, int duracionHoras, int precio, Guia guiaAsignado) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
        this.guiaAsignado = guiaAsignado;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public Guia getGuiaAsignado() { return guiaAsignado; }
    public void setGuiaAsignado(Guia guiaAsignado) { this.guiaAsignado = guiaAsignado; }

    /**
     * Muestra la información del servicio turístico.
     * Este método es sobrescrito por las subclases para aplicar polimorfismo.
     */
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre + " | Duración: " + duracionHoras + " hrs | Precio: $" + precio + " | " + guiaAsignado.toString());
    }

    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " hrs | Precio: $" + precio + " | " + guiaAsignado.toString();
    }
}
