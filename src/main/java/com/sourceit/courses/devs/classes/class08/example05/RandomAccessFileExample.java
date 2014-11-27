package com.sourceit.courses.devs.classes.class08.example05;

import java.io.*;

public class RandomAccessFileExample {

    public static void main(String[] args) {
        try {
            // create a new RandomAccessFile with filename test
            RandomAccessFile raf = new RandomAccessFile("src/main/resources/testRAF.txt", "rw");

            // write something in the file
            raf.writeUTF("Hello World");

            // set the file pointer at 0 position
            raf.seek(0);

            // print the line
            System.out.println("" + raf.readLine());

            // set the file pointer at 0 position
            raf.seek(raf.length());

            // write something in the file
            raf.writeUTF("This is an example\n Hello World");

            raf.seek(0);
            // print the line
            System.out.println("\n");
            System.out.println("" + raf.readLine());
            System.out.println("" + raf.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
