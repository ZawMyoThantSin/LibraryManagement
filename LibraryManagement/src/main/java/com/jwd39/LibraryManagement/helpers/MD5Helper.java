package com.jwd39.LibraryManagement.helpers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    private static byte[] digest(byte[] input){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
    private static String byteToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String encrypt(String arg){

            byte[] encrypt = MD5Helper.digest(arg.getBytes(UTF_8));
            return encrypt.toString();

    }
}
