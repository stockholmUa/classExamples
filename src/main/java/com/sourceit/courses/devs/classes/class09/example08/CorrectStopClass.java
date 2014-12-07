package com.sourceit.courses.devs.classes.class09.example08;


import java.util.concurrent.TimeUnit;

public class CorrectStopClass extends Thread {
    // Флаг завершения и метод для его установки
    private boolean stopFlag = false;
    public void stopIt() {
        stopFlag = true;
    }
    // Поток, который печатает свое имя каждые полсекунды
    public void run() {
        while (!stopFlag) {
            System.out.println(getName());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch (InterruptedException ex) {
            //DO NOTHING
            }
        }
    }

    public static void main(String[] args) {
        CorrectStopClass th = new CorrectStopClass();
        th.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th.stopIt();
    }
}
