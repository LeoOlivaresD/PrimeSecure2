package com.duoc.primesecure2;

import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.input.ReaderPrimes;
import com.duoc.primesecure2.output.WriterPrimesCsv;
import com.duoc.primesecure2.threads.PrimesThread;

public class PrimeSecure2 {

    public static void main(String[] args) {
        // Creación de objetos
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
    }
}
