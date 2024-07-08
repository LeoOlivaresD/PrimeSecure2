package com.duoc.primesecure2.input;

import com.duoc.primesecure2.entities.Mensaje;
import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.output.Encryptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderPrimes {

    //Metodo encargado de leer numeros primos desde un csv
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

    //Con este metodo desencriptare mensajes desde un txt
    public static List<Mensaje> leerMensajesEncriptados(String nombreArchivo, PrimesList primesList) {
        List<Mensaje> mensajes = new ArrayList<>();
        Encryptor encryptor = new Encryptor(primesList);

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parsea el mensaje y el id del archivo
                String[] parts = line.split(", mensaje= ");
                if (parts.length == 2) {
                    String idPart = parts[0].replace("Mensaje{idMensaje = ", "").trim();
                    String mensajePart = parts[1].replace('}', ' ').trim();

                    Integer idMensaje = Integer.parseInt(idPart);
                    String mensajeDesencriptado = encryptor.decryptMessage(mensajePart);

                    Mensaje mensaje = new Mensaje(mensajeDesencriptado, idMensaje);
                    mensajes.add(mensaje);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensajes;
    }
}
