package com.sourceit.courses.devs.classes.class07.maps.tree;



public class Dog implements Comparable<Dog> {
    String color;
    int size;

    Dog(String c, int s) {
        color = c;
        size = s;
    }

    public String toString(){
        return color + " dog";
    }

    @Override
    public int compareTo(Dog o) {
        return  o.size - this.size;
    }
}