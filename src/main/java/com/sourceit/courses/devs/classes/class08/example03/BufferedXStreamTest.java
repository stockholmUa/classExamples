package com.sourceit.courses.devs.classes.class08.example03;

import java.io.*;

public class BufferedXStreamTest {
    public static void main(String[] args) {
        String inFileStr = "src/main/resources/wave.png";
        String outFileStr = "src/main/resources/waveTestBufferedStream.png";

        long startTime;
        long elapsedTime;  // for speed benchmarking

        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

            startTime = System.nanoTime();
            int byteRead;

            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
