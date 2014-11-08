package com.sourceit.courses.devs.classes.class05.example03;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Clock {

    public void start(int interval, final boolean isSoundEnabled) {
        final int i = 5;

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Time when event was fired " + i + new Date());
                if (isSoundEnabled) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer timer = new Timer(interval, listener);
        timer.start();
    }



    public static void main(String[] args) {
        Clock c = new Clock();
        c.start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }


}
