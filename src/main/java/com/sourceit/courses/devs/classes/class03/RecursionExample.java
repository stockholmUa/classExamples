package com.sourceit.courses.devs.classes.class03;


public class RecursionExample {

    static int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sum(int n)  {
        if(n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));

        System.out.println(fibonacci(6));
    }
}
