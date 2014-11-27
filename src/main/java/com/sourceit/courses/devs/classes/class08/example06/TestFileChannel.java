package com.sourceit.courses.devs.classes.class08.example06;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write into file:
        FileChannel fc = new FileOutputStream("testFileChanel.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some test to test ".getBytes()));
        fc.close();

        // Add data at the end of the file:
        fc = new RandomAccessFile("testFileChanel.txt", "rw").getChannel();
        fc.position(fc.size()); // Set position to the end
        fc.write(ByteBuffer.wrap("A few more".getBytes()));
        fc.close();

        // Read from file:
        fc = new FileInputStream("testFileChanel.txt").getChannel();
        ByteBuffer buf = ByteBuffer.allocate(BSIZE);

        int bytesRead = fc.read(buf); //read into buffer.
        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear(); //make buffer ready for writing
            bytesRead = fc.read(buf);
        }
        fc.close();
    }

}
