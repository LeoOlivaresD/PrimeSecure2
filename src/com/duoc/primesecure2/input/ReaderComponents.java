package com.duoc.primesecure2.input;

import com.duoc.primesecure2.entities.Message;
import com.duoc.primesecure2.entities.PrimesList;
import com.duoc.primesecure2.output.Encryptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderComponents {

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
    public static List<Message> leerMensajesEncriptados(String nombreArchivo, PrimesList primesList) {
        List<Message> listaMensajes = new ArrayList<>();
        Encryptor decryptor = new Encryptor(primesList);

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",", 2); // Dividir solo en la primera coma
                int idMensaje = Integer.parseInt(partes[0]);
                String mensajeEncriptado = partes[1];
                String mensajeDesencriptado = decryptor.decryptMessage(mensajeEncriptado);

                Message mensaje = new Message(mensajeDesencriptado, idMensaje);
                listaMensajes.add(mensaje);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return listaMensajes;
    }
}
