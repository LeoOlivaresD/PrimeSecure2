package com.duoc.primesecure2.entities;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {
    private String mensaje;
    private Integer idMensaje;
    List<Mensaje> listaMensajes = new ArrayList<>();
    
    public Mensaje() {
    }

    public Mensaje(String mensaje, Integer idMensaje) {
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

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    

    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje = "  + idMensaje + ", mensaje= " + mensaje + '}';
    }
    
}
