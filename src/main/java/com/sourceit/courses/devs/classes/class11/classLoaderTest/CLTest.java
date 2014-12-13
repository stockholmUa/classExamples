package com.sourceit.courses.devs.classes.class11.classLoaderTest;


public class CLTest {
    // Dynamic Class Loading
    public static void main(String[] args){

        ClassLoader classLoader = CLTest.class.getClassLoader();

        try {
            Class aClass = classLoader.loadClass("com.sourceit.courses." +
                    "devs.classes.class10.Log4jTest");
            System.out.println("aClass.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
