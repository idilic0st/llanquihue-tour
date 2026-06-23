package model;

/**
 * Representa un tour ofrecido por la agencia.
 * Aplica composicion al incluir un objeto de tipo Guia.
 */
public class Tour {
    private String nombre;
    private String tipo;
    private int precio;
    private Guia guiaAsignado; // El Tour ahora contiene un Guía

    /**
     * Constructor de la clase Tour actualizado (Ahora pide 4 datos).
     *
     * @param nombre       Nombre del tour.
     * @param tipo         Categoría del tour (Cultural, Gastronomico, etc.).
     * @param precio       Valor del tour en pesos chilenos.
     * @param guiaAsignado Objeto Guia asignado responsable del tour.
     */
    public Tour(String nombre, String tipo, int precio, Guia guiaAsignado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.guiaAsignado = guiaAsignado;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    // Getters y Setters para el Guía
    public Guia getGuiaAsignado() { return guiaAsignado; }
    public void setGuiaAsignado(Guia guiaAsignado) { this.guiaAsignado = guiaAsignado; }

    @Override
    public String toString() {
        return "Tour: " + nombre + " | Tipo: " + tipo + " | Precio: $" + precio + " | " + guiaAsignado.toString();
    }
}