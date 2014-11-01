package com.sourceit.courses.devs.classes.class04.example02;


public class Example02 {

    class SubExample {
        SubExample(int marker) {
            Example02.print("SubExample(" + marker + ")");
        }
    }

    SubExample w1 = new SubExample(1); // Before constructor

    Example02() {
        // Show that we're in the constructor:
        print("Example02: Constructor");
        w3 = new SubExample(33); // Reinitialize w3
    }
    SubExample w2 = new SubExample(2); // After constructor
    void f() { print("f()"); }
    SubExample w3 = new SubExample(3); // At end

    public static void main(String[] args) {
        Example02 h = new Example02();
        h.f(); // Shows that construction is done
    }
    static void print(String line) {
        System.out.println(line);
    }
}
