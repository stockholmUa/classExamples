package com.sourceit.courses.devs.classes.class09.example01;

public class Test {
    public static void main(String[] args) {
        Thread th = new Thread(new LiftOff());
        th.start();
        new LiftOff().run();
    }
}
