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

        primesList.getPrimesCount();//Finalmente devuelvo la lista de numeros primos
        System.out.println("Generando archivo csv");
        WriterPrimesCsv.savePrimesListToCsv(primesList); // Guardo esa lista en un archivo csv
        ReaderComponents.readerCsv(); //Ademas implento metodo para poder leer el csv y añadir esos numeros a una lista

        //Aca impleneto la logica para generar un mensaje
        MensajeEncriptado mensajeEncriptado = new MensajeEncriptado(primesList);
        System.out.println("Ingrese un mensaje");
        Scanner sc = new Scanner(System.in);
        String mensaje = sc.nextLine();
        //Con este metodo guardo un mensaje, le asigno un id numero primo y ademas lo almaceno en un txt
        mensajeEncriptado.generarMensaje(mensajeria, primesList.get(0), mensaje);

        // Leo y desencripto mensajes usando ReaderPrimes
        List<Message> mensajes = ReaderComponents.leerMensajesEncriptados("listado_mensajes.txt", primesList);
        for (Message mensajee : mensajes) {
            System.out.println("Mensaje desencriptado: " + mensajee.getMensaje() + " id mensaje: "+ mensajee.getIdMensaje());
        }

    }
}
