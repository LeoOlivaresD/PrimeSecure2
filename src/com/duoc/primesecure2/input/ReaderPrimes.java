package com.duoc.primesecure2.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderPrimes {

    public static List<Integer> readerCsv() {
        String nombreArchivo = "primes_list.csv";
        List<Integer> listaCsv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            boolean isFirsLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirsLine) {
                    isFirsLine = false;
                    continue;
                }
                listaCsv.add(Integer.parseInt(line));
            }
            System.out.println("Impriendo lista de numeros cargados por csv");
            for (int i : listaCsv) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCsv;
    }
}
