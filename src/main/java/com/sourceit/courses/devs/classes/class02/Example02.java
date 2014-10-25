package com.sourceit.courses.devs.classes.class02;


public class Example02 {

    public static void main(String[] args) {
        byte b = 45;
        char c = 'c';
        short s = 1005;
        int i = 700000;
        float f = 4.55f;
        double d = 1.456;
        double result = (f * b) + (i / c) - (d * s);

        System.out.println("(f * b) " + ((Object)(f * b)).getClass());
        System.out.println("(i / c) " + ((Object)(i / c)).getClass());
        System.out.println("(d * s) " + ((Object)(d * s)).getClass());
        System.out.println("(f * b) + (i / c) " + ((Object)((f * b) + (i / c))).getClass());
        System.out.println("result " + ((Object)result).getClass());

        System.out.println();

        System.out.println("result равно " + result);
    }
}
