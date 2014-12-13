package com.sourceit.courses.devs.classes.class09.example01;


public class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 5; i > 0; i-- ) {
                System.out.println("My Thread: " + getName() + " count " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            // Exception can be thrown by sleep() method
            System.out.println("My Thread was interrupted.");
        }
        System.out.println("My Thread " + getName() + " is finished.");
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread.start();
        thread2.start();
        thread1.start();
        System.out.println("main is over");
    }
}

