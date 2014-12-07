package com.sourceit.courses.devs.classes.class09.example04;


import java.util.concurrent.*;

public class DaemonFromFactory implements Runnable {
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.print(Thread.currentThread() + " " + this);
            }
        } catch(InterruptedException e) {
            System.out.print("Interrupted");
        }
    }
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                }
        );
        for(int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500); // Run for a while
    }
}
