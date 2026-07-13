package model;

public abstract class ServicioTuristico implements Registrable {
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
    public int getDuracionHoras() { return duracionHoras; }
    public int getPrecio() { return precio; }
    public Guia getGuiaAsignado() { return guiaAsignado; }



    @Override
    public abstract String mostrarResumen();
}