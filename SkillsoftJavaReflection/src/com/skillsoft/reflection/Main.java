package com.skillsoft.reflection;

import java.lang.annotation.Annotation; // interface Annotation
import java.lang.reflect.InvocationTargetException; // class InvocationTargetException
import java.lang.reflect.Method; // class Method
import java.util.ArrayList; // class ArrayList
import java.util.List; // interface List

public class Main {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<?> employeeTestClass = Class.forName("com.skillsoft.reflection.EmployeeTest");

        Method[] methods = employeeTestClass.getDeclaredMethods();

        Method setupMethod = null;
        Method teardownMethod = null;

        List<Method> testcaseMethods = new ArrayList<>();

        for (Method method : methods) {

            Annotation setupAnnotation = method.getAnnotation(Setup.class);
            Annotation teardownAnnotation = method.getAnnotation(Teardown.class);
            Annotation testcaseAnnotation = method.getAnnotation(TestCase.class);

            if (setupAnnotation != null) {
                setupMethod = method;
            } else if (teardownAnnotation != null) {
                teardownMethod = method;
            } else if (testcaseAnnotation != null) {
                testcaseMethods.add(method);
            }

            System.out.println("---------------");

            System.out.println("Found setup method: " + setupMethod);
            System.out.println("Found teardown method: " + teardownMethod);
            System.out.println("Found testcase method: " + testcaseMethods);

            System.out.println();
        }

        System.out.println("----------------");
        if (setupMethod == null) {
            System.err.println("Please specify setup method!");
            System.exit(1);
        }
        if (teardownMethod == null) {
            System.err.println("Please specify teardown method!");
            System.exit(1);
        }
        if (testcaseMethods.isEmpty()) {
            System.err.println("Please specify testcases!");
            System.exit(1);
        }
        System.out.println();

        System.out.println("----------- Starting tests");

        Object employeeTestInstance = employeeTestClass.getConstructor().newInstance();

        List<Method> failedMethods = new ArrayList<>();

        for (Method method : testcaseMethods) {

            setupMethod.invoke(employeeTestInstance);

            try {
                method.invoke(employeeTestInstance);
                System.out.println("Testcase passed:-) " + method);
            } catch (InvocationTargetException e) {
                failedMethods.add(method);
                System.out.println("Testcase failed:-( " + method);
            }

            teardownMethod.invoke(employeeTestInstance);
        }

        System.out.println("------------- Test completed");

        if (!failedMethods.isEmpty()) {
            System.out.println("The following test cases failed");

            for (Method method : failedMethods) {
                System.out.println(method.getName());
            }
        } else {
            System.out.println("All tests passed!");
        }
    }
}

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
// Java docs for java.lang.reflect.InvocationHandler

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
// Java docs for java.lang.reflect.Proxy, the superclass for dynamic proxy classes