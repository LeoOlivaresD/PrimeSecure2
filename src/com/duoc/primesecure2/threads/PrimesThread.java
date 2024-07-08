package com.duoc.primesecure2.threads;

import com.duoc.primesecure2.entities.PrimesList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrimesThread implements Runnable {

    private PrimesList primesList; //Creo un atributo de est clase para mantener una unic instancia en el main
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
        // Generar numero random y determinar con el metodo isPrime si es primo para luego agregarlo a una lista
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1); // Pauso el hilo por 1 segundo
                Random numeroRamdon = new Random(); //Comienzo con logica pra crear numero random
                int min = 1;
                int max = 100000;
                int numeroGenerado = numeroRamdon.nextInt(max - min + 1) + min;
                System.out.println(numeroGenerado);
                //valido si el numero es primo, en caso de serlo, se agrega a la lista
                if (primesList.isPrime(numeroGenerado)) {
                    System.out.println("Es primo");
                    primesList.add(numeroGenerado);
                    //Luego de agregar ese numero a la lista lo paso a una lista sincronizada
                    syncList = Collections.synchronizedList(primesList); //USO DE LISTA SINCRONIZADA
                }
            }
            System.out.println("Tamaño de la lista: " + primesList.size()); //Imprimo el tamaño de lista para verificar concordancia con numeros guardados
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
