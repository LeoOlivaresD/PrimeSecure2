package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.Message;
import com.duoc.primesecure2.entities.PrimesList;
import java.io.FileWriter;
import java.io.IOException;

public class MensajeEncriptado {
    private static PrimesList primesList;
    private static Encryptor encryptor;
    
    public MensajeEncriptado(PrimesList primesList) {
        MensajeEncriptado.primesList = primesList;
        MensajeEncriptado.encryptor = new Encryptor(primesList);
    }
    
    public synchronized static void generarMensaje(Message mensaje, Integer idMensaje, String inputUsuario) {
        String encryptedMessage = encryptor.encryptMessage(inputUsuario);
        mensaje.setMensaje(encryptedMessage);
        mensaje.setIdMensaje(idMensaje);
        mensaje.getListaMensajes().add(mensaje);
        //guardo el mensaje en un archivo de texto
        guardarMensajeEnTxt(mensaje);
    }

    public synchronized static void guardarMensajeEnTxt(Message mensaje) {
        String salto = System.lineSeparator();
        try (FileWriter fw = new FileWriter("listado mensajes.txt", true)) {
            fw.write(mensaje.toString() + salto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
