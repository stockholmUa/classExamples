package com.sourceit.courses.devs.classes.class08.example07;


import java.io.*;

public class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream ois = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/state.bin"));

        ois.writeDouble(3.14159265D);
        ois.writeObject("The value of PI");
        ois.writeObject(new Point(10,253));
        ois.flush();
        ois.close();


        ObjectInputStream sois = new ObjectInputStream(
                new FileInputStream("src/main/resources/state.bin"));
        System.out.println("Double: " + sois.readDouble());
        System.out.println("String: " + sois.readObject().toString());
        System.out.println("Point: " + sois.readObject());
        sois.close();

    }
}
