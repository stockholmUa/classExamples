package com.sourceit.courses.devs.classes.class11.example02;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RefClass {
    public static void main(String args[]) {

        try {

            // create a new instance with the help of reflection
            Object testObj = TestObject.class.newInstance();

            // call getName method
            System.out.println("Method getName() result: "
                    + invokeMethod(testObj, "getName", null, null));

            // access to the class field
            Field privateStringField = testObj.getClass().getDeclaredField("name");
            privateStringField.setAccessible(true);
            String name = (String) privateStringField.get(testObj);
            System.out.println("Value of name = field " + name);

            System.out.println("Change the value of the name field");
            privateStringField.set(testObj, "New value");
            name = (String) privateStringField.get(testObj);
            System.out.println("Now the name value = " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Object invokeMethod(Object object, final String methodName,
                                       final Class<?>[] paramsTypes, Object arg) {

        Object result = null;

        try {

            // type of the object which was called method for
            Class<?> targetObjectClass = object.getClass();

            // get class method
            Method method = findMethodAtClass(targetObjectClass, paramsTypes,
                    methodName);

            // if method has arguments
            if (arg != null)
                result = method.invoke(object, arg);
            else
                result = method.invoke(object);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static Method findMethodAtClass(final Class<?> type,
                                            final Class<?>[] paramsTypes, final String methodName)
            throws NoSuchMethodException {

        Class<?> currentType = type;
        Method[] methods = type.getMethods();

        // search for method with methodName  name in set class and all its super classes
        while (currentType != null) {
            for (Method buff : methods) {

                if (buff.getName().equals(methodName)) {

                    if (paramsTypes != null) {
                        Class<?>[] params = buff.getParameterTypes();
                        if (Arrays.deepEquals(paramsTypes, params))
                            return buff;
                    } else if (buff.getParameterTypes().length == 0)
                        return buff;
                }
            }

            currentType = currentType.getSuperclass();
        }

        throw new NoSuchMethodException();
    }
}
