package com.sourceit.courses.devs.classes.class08.example03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileXStreamBuffersTest {
    public static void main(String[] args) {
        String inFileStr = "src/main/resources/wave.png";
        String outFileStr = "src/main/resources/waveTestFileBuffersStream.png";

        long startTime;
        long elapsedTime;  // for speed benchmarking

        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        int[] bufSizeKB = {1, 2, 4, 8, 16, 32, 64, 256, 1024};  // in KB
        int bufSize;  // in bytes

        for (int run = 0; run < bufSizeKB.length; run++) {
            bufSize = bufSizeKB[run] * 1024;

            try (FileInputStream in = new FileInputStream(inFileStr);
                 FileOutputStream out = new FileOutputStream(outFileStr)) {

                startTime = System.nanoTime();

                byte[] byteBuf = new byte[bufSize];
                int numBytesRead;

                while ((numBytesRead = in.read(byteBuf)) != -1) {
                    out.write(byteBuf, 0, numBytesRead);
                }

                elapsedTime = System.nanoTime() - startTime;
                System.out.printf("%4dKB: %6.2f msec%n", bufSizeKB[run], (elapsedTime / 1000000.0));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
