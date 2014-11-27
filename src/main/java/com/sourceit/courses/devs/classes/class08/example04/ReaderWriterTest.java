package com.sourceit.courses.devs.classes.class08.example04;

import java.io.*;

public class ReaderWriterTest {
    public static void main(String[] args) {
        String strFilename = "src/main/resources/testReaderWriter.txt";
        String message = "Hello, world!\nHello, world again!\n";  // 2 lines of texts

        // Print the default charset
        System.out.println(java.nio.charset.Charset.defaultCharset());

        try (BufferedWriter out = new BufferedWriter(new FileWriter(strFilename))) {
            out.write(message);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader(strFilename))) {
            String inLine;
            while ((inLine = in.readLine()) != null) {  // exclude newline
                System.out.println(inLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
