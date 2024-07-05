package com.duoc.primesecure2;

import com.duoc.primesecure2.entities.Mensajeria;
import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.input.ReaderPrimes;
import com.duoc.primesecure2.output.MensajeEncriptado;
import com.duoc.primesecure2.output.WriterPrimesCsv;
import com.duoc.primesecure2.threads.PrimesThread;
import java.util.Scanner;

public class PrimeSecure2 {

    public static void main(String[] args) {
        // Creación de objetos
        Mensajeria mensajeria = new Mensajeria();
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
        WriterPrimesCsv.savePrimesListToCsv(primesList);
        ReaderPrimes.readerCsv();
        
        System.out.println("Ingrese un mensaje");
        Scanner sc = new Scanner(System.in);
        String mensaje = sc.nextLine();
        MensajeEncriptado.generarMensaje(mensajeria, primesList.get(0), mensaje);
        
        System.out.println(mensajeria.toString());
        
    }
}
