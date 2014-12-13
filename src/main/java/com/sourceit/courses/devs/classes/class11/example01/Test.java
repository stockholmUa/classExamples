package com.sourceit.courses.devs.classes.class11.example01;


import java.lang.reflect.*;
import java.lang.annotation.Annotation;
import java.io.Serializable;

public abstract class Test implements Serializable, Cloneable {
    private int field;

    public Test(Object field) { }

    @Deprecated
    protected static void method(String[] params) { }
}

class Reflect {
    public static void main(String[] args) {
        Class clazz = Test.class;

        // find out package name
        Package p = clazz.getPackage();
        System.out.println("package " + p.getName() + ";");

        // Get all class modifiers
        int modifiers = clazz.getModifiers();
        System.out.print(getModifiers(modifiers));

        // Class name
        System.out.print("class " + clazz.getSimpleName() + " ");

        // Get Parent Class
        System.out.print("extends " + clazz.getSuperclass().getSimpleName() + " ");

        // Get all implemented interfaces
        Class[] interfaces = clazz.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println(" {");

        // Get all class fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + getModifiers(field.getModifiers())
                    + getType(field.getType()) + " " + field.getName() + ";");
        }

        // get class constructors
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.print("\t" + getModifiers(c.getModifiers()) +
                    clazz.getSimpleName() + "(");
            System.out.print(getParameters(c.getParameterTypes()));
            System.out.println(") { }");
        }

        // get class methods
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // get annotations
            Annotation[] annotations = m.getAnnotations();
            System.out.print("\t");
            for (Annotation a : annotations) {
                System.out.print("@" + a.annotationType().getSimpleName() + " ");
            }
            System.out.println();

            System.out.print("\t" + getModifiers(m.getModifiers()) +
                    getType(m.getReturnType()) + " " + m.getName() + "(");
            System.out.print(getParameters(m.getParameterTypes()));
            System.out.println(") { }");
        }

        System.out.println("}");
    }

    static String getModifiers(int m) {
        String modifiers = "";
        if (Modifier.isPublic(m)) modifiers += "public ";
        if (Modifier.isProtected(m)) modifiers += "protected ";
        if (Modifier.isPrivate(m)) modifiers += "private ";
        if (Modifier.isStatic(m)) modifiers += "static ";
        if (Modifier.isAbstract(m)) modifiers += "abstract ";
        return modifiers;
    }

    static String getType(Class clazz) {
        String type = clazz.isArray()
                ? clazz.getComponentType().getSimpleName()
                : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }

    static String getParameters(Class[] params) {
        String p = "";
        for (int i = 0, size = params.length; i < size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }
}
