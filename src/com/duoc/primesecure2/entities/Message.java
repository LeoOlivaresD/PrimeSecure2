package com.duoc.primesecure2.entities;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private String mensaje;
    private Integer idMensaje;
    List<Message> listaMensajes = new ArrayList<>();
    
    public Message() {
    }

    public Message(String mensaje, Integer idMensaje) {
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

    public List<Message> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Message> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    

    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje = "  + idMensaje + ", mensaje= " + mensaje + '}';
    }
    
}
