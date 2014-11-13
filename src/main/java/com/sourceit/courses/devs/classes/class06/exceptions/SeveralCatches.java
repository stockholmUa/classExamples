package com.sourceit.courses.devs.classes.class06.exceptions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

public class SeveralCatches {
    public void deposit(double amount) throws RemoteException
    {
        // Method implementation
        throw new RemoteException();
    }

    public static void main(String args[]){
        FileInputStream file;
        byte x;
        try {
            file = new FileInputStream("testFile.txt");
            x = (byte) file.read();
        }catch(FileNotFoundException i) {
            System.out.println("FileNotFoundException");
            i.printStackTrace();
        }catch(IOException f) {//Not valid!
            System.out.println("IOException");
            f.printStackTrace();
        }
    }
}
