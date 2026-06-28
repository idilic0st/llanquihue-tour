package model;

/**
 * Superclase que representa un servicio turístico genérico.
 * Aplica composición al incluir un objeto de tipo Guia.
 */
public class ServicioTuristico {
    protected String nombre;
    protected int duracionHoras;
    protected int precio; // Mantenemos el precio del código original para los filtros
    protected Guia guiaAsignado; // Composición con tu clase Guia

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

    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " hrs | Precio: $" + precio + " | " + guiaAsignado.toString();
    }
}
