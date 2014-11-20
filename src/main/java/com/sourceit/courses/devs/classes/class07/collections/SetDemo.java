package com.sourceit.courses.devs.classes.class07.collections;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        // create a hash set
        HashSet<String> hs = new HashSet<>();
        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);


        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // add elements to the hash set
        lhs.add("B");
        lhs.add("A");
        lhs.add("D");
        lhs.add("E");
        lhs.add("C");
        lhs.add("F");
        System.out.println(lhs);



        TreeSet<String> ts = new TreeSet<>();
        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);
    }
}
