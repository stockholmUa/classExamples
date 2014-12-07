package com.sourceit.courses.devs.classes.class09.example07.bookExample;

public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while(taken) {
            wait();
        }
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
