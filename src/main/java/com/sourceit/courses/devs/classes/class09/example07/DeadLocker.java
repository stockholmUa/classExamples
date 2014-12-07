package com.sourceit.courses.devs.classes.class09.example07;


import java.util.concurrent.TimeUnit;

public class DeadLocker extends Thread{
    Object a;
    Object b;
    public DeadLocker (Object a, Object b, String name) {
        super(name);
        this.a = a;
        this.b = b;
    }
    public void run() {
        // ввод монитора а
        synchronized (a) {
            System.out.println(getName() + ": step A");
            // передача процессора другому потоку
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ввод монитора b
            synchronized (b) {
                System.out.println(getName() + ": step B");
            }
        }
    }

    public static void main(String[] args) {
        // Объекты a и b, которые послужат мониторами
        Object a = new Object();
        Object b = new Object();
        // Первый поток получает объекты a и b
        new DeadLocker(a, b, "First").start();
        // Второй поток получает те же объекты в другом порядке
        new DeadLocker (b, a, "Second").start();

    }
}
