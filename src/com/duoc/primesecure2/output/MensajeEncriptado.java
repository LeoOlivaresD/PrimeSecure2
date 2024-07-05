
package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.Mensajeria;

public class MensajeEncriptado {
    
     public static void generarMensaje(Mensajeria mensajeria, Integer idMensaje, String inputUsuario){
        mensajeria.setMensaje(inputUsuario);
        mensajeria.setIdMensaje(idMensaje);
        mensajeria.getListaMensajes().add(mensajeria);
    }
}
