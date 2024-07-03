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
    
    //Sobreescribo los metodos "add" y remove"
    @Override
    public boolean add(Integer numero) {
        if (!isPrime(numero)) {
            throw new IllegalArgumentException("El número " + numero + " no es primo y no puede ser agregado a la lista.");
        }
        return super.add(numero);
    }
    //Con este metodo eliminare el  primer objeto de la lista especificado
    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            System.out.println("Eliminando el número " + o + " de la lista.");
        }
        return super.remove(o);
    }
    //Aca eliminare un elemento segun el indice indicado
    @Override
    public Integer remove(int index) {
        Integer numero = get(index);
        System.out.println("Eliminando el número " + numero + " de la lista.");
        return super.remove(index);
    }
    
    //Con este metodo determino si el numero es primo
    public static boolean isPrime(Integer numero) {
        //Verifico primero si el numero es igual o menor a 1 para descartar de inmediato ese valor 
        if (numero <= 1) {
            System.out.println("Numeros menores o igual 1 no son primoss");
            return false;  // 1 no es primo
        }
        //Aca verifico si el numero es divisible por algun numero entero entre 2 y su raiz cuadrada
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                System.out.println("No es primo");
                return false;
            }
        }
        //Si no encuentro un divisor , el numero es primo
        System.out.println("Es primo");
        return true;

    }
    //Con este metodo imprimo una lista de numeros primos
    public void getPrimesCount(PrimesList primesList) {
        System.out.println("Imprimiendo numeros primos de la lista");
        for (int n : primesList) {
            System.out.println(n);
        }
    }
    
}
