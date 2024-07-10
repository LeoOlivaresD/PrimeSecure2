package com.duoc.primesecure2;

import com.duoc.primesecure2.entities.Message;
import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.input.ReaderComponents;
import com.duoc.primesecure2.output.MensajeEncriptado;
import com.duoc.primesecure2.output.WriterPrimesCsv;
import com.duoc.primesecure2.threads.PrimesThread;
import java.util.List;
import java.util.Scanner;

public class PrimeSecure2 {

    public static void main(String[] args) {
        // Creación de objetos
        Message mensajeria = new Message();
        PrimesList primesList = new PrimesList();
        PrimesThread runnable = new PrimesThread(primesList);//paso el objeto de primesList en el constructor de mi clase PrimesThread
        Thread thread = new Thread(runnable);
        thread.start();//inicializo el hilo
        try {
            thread.join(); // Espero a que el hilo termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        primesList.getPrimesCount(); //Finalmente devuelvo la lista de numeros primos
        System.out.println("Generando archivo csv");
        WriterPrimesCsv.savePrimesListToCsv(primesList); // Guardo esa lista en un archivo csv
        System.out.println("Archivo csv guardado con exito");
        System.out.println("Leyendo archivo csv");
        ReaderComponents.readerCsv(); //Ademas implento metodo para poder leer el csv y añadir esos numeros a una lista

        //Aca implemento la logica para generar un mensaje
        System.out.println("Sistema de encriptacion listo");
        MensajeEncriptado mensajeEncriptado = new MensajeEncriptado(primesList);
        System.out.println("Ya puede ingresar un mensaje");
        Scanner sc = new Scanner(System.in);
        String mensaje = sc.nextLine();
        //Con este metodo guardo un mensaje, le asigno un id numero primo y ademas lo almaceno en un txt
        System.out.println("Guardando mensaje encriptado en archivo txt...");
        mensajeEncriptado.generarMensaje(mensajeria, primesList.get(0), mensaje);
        System.out.println("Listo !!");
        // Leo y desencripto mensajes usando ReaderComponents
        System.out.println("Leyendo mensaje encriptado");
        List<Message> mensajes = ReaderComponents.leerMensajesEncriptados("listado_mensajes.txt", primesList);
        for (Message mensajee : mensajes) {
            System.out.println("Mensaje desencriptado: " + mensajee.getMensaje() + " id mensaje: " + mensajee.getIdMensaje());
        }

    }
}
