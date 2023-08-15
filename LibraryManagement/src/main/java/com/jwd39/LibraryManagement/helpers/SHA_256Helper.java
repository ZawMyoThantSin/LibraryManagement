package com.jwd39.LibraryManagement.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256Helper {
    public static String encrypt(String input) {
        try {
            // Create a MessageDigest instance with the desired hashing algorithm (e.g., SHA-256)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the input string to bytes and compute the hash
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert the hash bytes to a hexadecimal representation
            StringBuilder hashBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hashBuilder.append(String.format("%02x", b));
            }

            return hashBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
