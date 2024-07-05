package com.duoc.primesecure2.entities;

import java.util.ArrayList;
import java.util.List;

public class Mensajeria {
    private String mensaje;
    private Integer idMensaje;
    List<Mensajeria> listaMensajes = new ArrayList<>();
    
    public Mensajeria() {
    }

    public Mensajeria(String mensaje, Integer idMensaje) {
        this.mensaje = mensaje;
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public List<Mensajeria> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensajeria> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    

    @Override
    public String toString() {
        return "Mensajeria{" + "mensaje=" + mensaje + ", idMensaje=" + idMensaje + '}';
    }
}
