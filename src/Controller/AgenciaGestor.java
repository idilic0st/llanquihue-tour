package controller;

import model.Registrable;
import java.util.ArrayList;
import java.util.List;

public class AgenciaGestor {
    private List<Registrable> listaEntidades;

    public AgenciaGestor() {
        this.listaEntidades = new ArrayList<>();
    }

    public List<Registrable> getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(List<Registrable> listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    public void agregarEntidad(Registrable entidad) {
        this.listaEntidades.add(entidad);
    }
}