package com.duoc.primesecure2.entities;

import java.util.ArrayList;
import java.util.Collection;

public class PrimesList extends ArrayList<Integer> {

    public PrimesList(int initialCapacity) {
        super(initialCapacity);
    }

    public PrimesList() {
    }

    public PrimesList(Collection<? extends Integer> c) {
        super(c);
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    // Sobreescribo los metodos "add" y "remove"
    @Override
    public boolean add(Integer numero) {
        if (!isPrime(numero)) {
            throw new IllegalArgumentException("El número " + numero + " no es primo y no puede ser agregado a la lista.");
        }
        return super.add(numero);
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            System.out.println("Eliminando el número " + o + " de la lista.");
        }
        return super.remove(o);
    }

    @Override
    public Integer remove(int index) {
        Integer numero = get(index);
        System.out.println("Eliminando el número " + numero + " de la lista.");
        return super.remove(index);
    }

    // Con este metodo determino si el numero es primo
    public static boolean isPrime(Integer numero) {
        if (numero <= 1) {
            System.out.println("Numeros menores o igual 1 no son primos");
            return false;  // 1 no es primo
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                System.out.println("No es primo");
                return false;
            }
        }
        return true;
    }

    // Con este metodo imprimo una lista de numeros primos
    public void getPrimesCount() {
        System.out.println("Imprimiendo numeros primos de la lista");
        for (int n : this) { //con este this me refiero a la clase misma y como es una lista la recorre con un for each
            System.out.println(n);
        }
    }
}
