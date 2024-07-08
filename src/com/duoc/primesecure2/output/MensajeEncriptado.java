package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.Message;
import com.duoc.primesecure2.entities.PrimesList;
import java.io.FileWriter;
import java.io.IOException;

public class MensajeEncriptado {

    private PrimesList primesList;
    private Encryptor encryptor;

    public MensajeEncriptado(PrimesList primesList) {
        this.primesList = primesList;
        this.encryptor = new Encryptor(primesList);
    }

    public synchronized void generarMensaje(Message mensaje, Integer idMensaje, String inputUsuario) {
        String encryptedMessage = encryptor.encryptMessage(inputUsuario);
        mensaje.setMensaje(encryptedMessage);
        mensaje.setIdMensaje(idMensaje);
        mensaje.getListaMensajes().add(mensaje);
        //guardo el mensaje en un archivo de texto
        guardarMensajeEnTxt(mensaje);
    }

    public synchronized void guardarMensajeEnTxt(Message mensaje) {
        String salto = System.lineSeparator();
        try (FileWriter fw = new FileWriter("listado_mensajes.txt", true)) {
            fw.write(mensaje.getIdMensaje() + "," + mensaje.getMensaje() + salto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
