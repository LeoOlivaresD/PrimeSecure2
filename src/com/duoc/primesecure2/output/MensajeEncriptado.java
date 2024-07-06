package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.Mensaje;
import java.io.FileWriter;
import java.io.IOException;

public class MensajeEncriptado {
    public static void generarMensaje(Mensaje mensaje, Integer idMensaje, String inputUsuario) {
        mensaje.setMensaje(inputUsuario);
        mensaje.setIdMensaje(idMensaje);
        mensaje.getListaMensajes().add(mensaje);
        //guardo el mensaje en un archivo de texto
        guardarMensajeEnTxt(mensaje);
    }

    public static void guardarMensajeEnTxt(Mensaje mensaje) {
        String salto = System.lineSeparator();
        try (FileWriter fw = new FileWriter("listado mensajes.txt", true)) {
            fw.write(mensaje.toString() + salto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
