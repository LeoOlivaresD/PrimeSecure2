package com.duoc.primesecure2.threads;

import com.duoc.primesecure2.entities.PrimesList;
import java.util.Random;

public class PrimesThread implements Runnable {

    private PrimesList primesList; //Creo un atributo de est clase para mantener una unic instancia en el main
    
    //Constructor
    public PrimesThread(PrimesList primesList) {
        this.primesList = primesList;
    }

    @Override
    public void run() {
        // Generar numero random y determinar con el metodo isPrime si es primo para luego agregarlo a una lista
        try {
            for (int i = 0; i < 15; i++) {
                Thread.sleep(1000); // Pauso el hilo por 1 segundo
                Random numeroRamdon = new Random(); //Comienzo con logica pra crear numero random
                int min = 1;
                int max = 100000;
                int numeroGenerado = numeroRamdon.nextInt(max - min + 1) + min;
                System.out.println(numeroGenerado);
                //valido si el numero es primo, en caso de serlo, se agrega a la lista
                if (primesList.isPrime(numeroGenerado)) {
                    System.out.println("Es primo");
                    primesList.add(numeroGenerado);
                }
            }
            System.out.println("Tamaño de la lista: " + primesList.size()); //Imprimo el tamaño de lista para verificar concordancia con numeros guardados
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
