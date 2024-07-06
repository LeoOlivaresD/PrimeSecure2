package com.duoc.primesecure2;

import com.duoc.primesecure2.entities.Mensaje;
import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.input.ReaderPrimes;
import com.duoc.primesecure2.output.MensajeEncriptado;
import com.duoc.primesecure2.output.WriterPrimesCsv;
import com.duoc.primesecure2.threads.PrimesThread;
import java.util.Scanner;

public class PrimeSecure2 {

    public static void main(String[] args) {
        // Creación de objetos
        Mensaje mensajeria = new Mensaje();
        PrimesList primesList = new PrimesList();
        PrimesThread runnable = new PrimesThread(primesList);//paso el objeto de primesList en el constructor de mi clase PrimesThread
        Thread thread = new Thread(runnable);
        thread.start();//inicializo el hilo

        try {
            thread.join(); // Espero a que el hilo termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        primesList.getPrimesCount();//finalmente devuelvo la lista de numeros primos
        System.out.println("Generando archivo csv");
        WriterPrimesCsv.savePrimesListToCsv(primesList); // guardo esa lista en un archivo csv
        ReaderPrimes.readerCsv(); //Ademas implento metodo para poder leer el csv y añadir esos numeros a una lista
        
        //Aca impleneto la logica para generar un mensaje
        System.out.println("Ingrese un mensaje");
        Scanner sc = new Scanner(System.in);
        String mensaje = sc.nextLine();
        //Con este metodo guardo un mensaje, le asigno un id umero primo y ademas lo almaceno en un txt
        MensajeEncriptado.generarMensaje(mensajeria, primesList.get(0), mensaje);
        
        System.out.println(mensajeria.toString());
        
    }
}
