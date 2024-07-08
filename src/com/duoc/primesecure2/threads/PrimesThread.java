package com.duoc.primesecure2.threads;

import com.duoc.primesecure2.entities.PrimesList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrimesThread implements Runnable {

    private final PrimesList primesList; //Creo un atributo de est clase para mantener una unica instancia en el main
    private List<Integer> syncList;

    //Constructor
    public PrimesThread(PrimesList primesList) {
        this.primesList = primesList;
    }

    public PrimesThread(PrimesList primesList, List<Integer> syncList) {
        this.primesList = primesList;
        this.syncList = syncList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 299; i++) {
                synchronized (primesList) {
                    // Genera un número aleatorio
                    Random random = new Random();
                    int min = 1;
                    int max = 100000;
                    int numeroGenerado = random.nextInt(max - min + 1) + min;
                    
                    // Valida si el número es primo
                    if (primesList.isPrime(numeroGenerado)) {
                        primesList.add(numeroGenerado);
                        syncList = Collections.synchronizedList(primesList); //USO DE LISTA SYNCRONIZADA
                    }

                    // Pausar el hilo si el tamaño de la lista es múltiplo de 25
                    if (primesList.size() % 25 == 0) {
                        System.out.println("Pausando el hilo por medio segundo...");
                        primesList.wait(500);
                        primesList.notifyAll(); // Notifica para continuar
                        System.out.println("Reanudando");
                    }
                }
            }
            System.out.println("Tamaño de la lista: " + primesList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
