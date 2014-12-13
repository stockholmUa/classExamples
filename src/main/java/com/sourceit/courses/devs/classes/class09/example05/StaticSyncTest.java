package com.sourceit.courses.devs.classes.class09.example05;

import java.util.concurrent.TimeUnit;

class StaticMethodClass {
    public synchronized static void f() {
        System.out.println("f() started");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("f() finished");
    }
}

class StaticTestThread extends Thread {
    public void run() {
        StaticMethodClass.f();
    }
}

public class StaticSyncTest {
    public static void main(String[] args) {
        StaticTestThread ts = new StaticTestThread();
        ts.start();

        synchronized(StaticMethodClass.class) {
            System.out.println("We are in synchronized section");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
