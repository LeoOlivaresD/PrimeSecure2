package com.duoc.primesecure2.output;

import com.duoc.primesecure2.entities.PrimesList;

public class Encryptor {
    private PrimesList primesList;

    public Encryptor(PrimesList primesList) {
        this.primesList = primesList;
    }

    public String encryptMessage(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        int primeIndex = 0;
        
        for (char c : message.toCharArray()) {
            int prime = primesList.get(primeIndex % primesList.size());
            encryptedMessage.append((char) (c + prime));
            primeIndex++;
        }

        return encryptedMessage.toString();
    }

    public String decryptMessage(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();
        int primeIndex = 0;

        for (char c : encryptedMessage.toCharArray()) {
            int prime = primesList.get(primeIndex % primesList.size());
            decryptedMessage.append((char) (c - prime));
            primeIndex++;
        }

        return decryptedMessage.toString();
    }
}
