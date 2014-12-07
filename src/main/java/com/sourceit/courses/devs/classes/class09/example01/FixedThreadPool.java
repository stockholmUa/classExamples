package com.sourceit.courses.devs.classes.class09.example01;

import com.sourceit.courses.devs.classes.class09.example01.LiftOff;
import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args) {
        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(3);
        // Executors.newCachedThreadPool();
        // Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
