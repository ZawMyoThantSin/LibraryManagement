package com.jwd39.LibraryManagement.helpers;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Base64Converter {
    public static void main(String[] args) {
        String path = "C:\\Users\\HUAWEI\\Pictures\\Saved Pictures\\cc.jpg";
        System.out.println(imgToBase(path));
    }

    public static String imgToBase(String img_path) {
        File f = new File(img_path);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] imagebytearray = new byte[(int) f.length()];
        try {
            fin.read(imagebytearray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imagetobase64 = Base64.encodeBase64String(imagebytearray);
        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagetobase64;
    }
}

