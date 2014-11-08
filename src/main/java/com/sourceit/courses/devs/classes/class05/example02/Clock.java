package com.sourceit.courses.devs.classes.class05.example02;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;



public class Clock {
    private int interval = 10;
    private boolean isSoundEnabled = false;

    public Clock(int interval, boolean isSoundEnabled) {
        this.interval = interval;
        this.isSoundEnabled = isSoundEnabled;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }


    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time when event was fired " + new Date());
            if (isSoundEnabled) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }


    public static void main(String[] args) {
        Clock c = new Clock(1000, true);
        c.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }


}
