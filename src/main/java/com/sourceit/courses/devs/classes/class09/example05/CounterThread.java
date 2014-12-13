package com.sourceit.courses.devs.classes.class09.example05;

class Counter {

    long count = 0;

    public synchronized void add(long value, String threadName){
        this.count += value;
        System.out.println(count + " - " + threadName);
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

public class CounterThread extends Thread {
    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i, getName());

        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter);
        Thread  threadB = new CounterThread(counter);

        Counter counter1 = new Counter();
        Thread  threadA1= new CounterThread(counter1);
        Thread  threadB1 = new CounterThread(counter1);

        threadA.start();
        threadB.start();
    }
}
