package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.PrimesList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterPrimesCsv {

    public static void savePrimesListToCsv(PrimesList primesList) {
        String nombreArchivo = "primes_list.csv";
        File file = new File(nombreArchivo);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Primes numbers");
            bw.newLine();
            for (int i : primesList) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
