package com.sourceit.courses.devs.classes.class05.example01;

import java.util.Iterator;

public class Example01 {

    private class InnerClass implements Iterator {
        private int curr = 0;
        @Override
        public boolean hasNext() {
            for (int i = curr; i < arr.length; i++) {
                if (arr[i] != null)
                    return true;
            }
            return false;
        }
        @Override
        public Object next() {
            while (curr < arr.length && arr[curr] == null)
                curr++;
            if (curr < arr.length) {
                return arr[curr++];
            }
            return null;
        }

        @Override
        public void remove() {
        }
    }

    private Object arr[];



    public Example01(Object arr[]) {
        this.arr = arr;
    }
    public Iterator iterator () {
        return new InnerClass();
    }


    public static void main(String[] args) {
        Object[] arr = {null, "abc", null, new Integer(123), null};
        Iterator it = new Example01(arr).iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
