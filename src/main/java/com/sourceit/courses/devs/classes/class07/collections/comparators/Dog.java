package com.sourceit.courses.devs.classes.class07.collections.comparators;

import java.util.Comparator;

public class Dog implements Comparator<Dog>, Comparable<Dog>{
    private String name;
    private int age;
    Dog() {}

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDogName(){
        return name;
    }

    public int getDogAge(){
        return age;
    }

    // Overriding the compareTo method
    public int compareTo(Dog d){
        return (this.name).compareTo(d.name);
    }

    // Overriding the compare method to sort the age
    public int compare(Dog d, Dog d1){
        return d.age - d1.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (age != dog.age) return false;
        if (!name.equals(dog.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
