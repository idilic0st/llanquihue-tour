package model;

public class ColaboradorExterno implements Registrable {
    private String nombre;
    private String rubro;     // Ej: "Traslados Fluviales"
    private int tarifaConvenio; // Ej: 75000

    public ColaboradorExterno(String nombre, String rubro, int tarifaConvenio) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.tarifaConvenio = tarifaConvenio;
    }

    public String getNombre() { return nombre; }
    public String getRubro() { return rubro; }
    public int getTarifaConvenio() { return tarifaConvenio; }

    @Override
    public String mostrarResumen() {
        return "Socio Externo: " + nombre + " | Servicio: " + rubro + " | Convenio: $" + tarifaConvenio;
    }
}