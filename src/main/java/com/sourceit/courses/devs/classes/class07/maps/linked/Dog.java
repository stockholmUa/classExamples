package com.sourceit.courses.devs.classes.class07.maps.linked;



public class Dog {
    String color;

    Dog(String c) {
        color = c;
    }

    public boolean equals(Object o) {
        return ((Dog) o).color == this.color;
    }

    public int hashCode() {
        return color.length();
    }

    public String toString(){
        return color + " dog";
    }
}