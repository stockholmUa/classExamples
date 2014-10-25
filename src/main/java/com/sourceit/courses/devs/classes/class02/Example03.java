package com.sourceit.courses.devs.classes.class02;


public class Example03 {
    public static void main(String[] args) {
        byte x = 64;
        byte y;
        int i;

        i = x << 2; // сдвиг влево
        y = (byte) (x << 2); // сдвиг влево с приведением


        System.out.println("i равно: " + i + "\n");
        System.out.println("y равно: " + y);

        int a = 35;
        a = a >> 2;
        System.out.println("\n\na равно: " + a);
    }
}
