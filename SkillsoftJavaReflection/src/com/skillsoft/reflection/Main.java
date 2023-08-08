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

        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: null
        //Found testcase method: []
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: []
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: [public void com.skillsoft.reflection.EmployeeTest.testBonus()]
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: [public void com.skillsoft.reflection.EmployeeTest.testBonus()]
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: [public void com.skillsoft.reflection.EmployeeTest.testBonus(), public void com.skillsoft.reflection.EmployeeTest.testGetters()]
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: [public void com.skillsoft.reflection.EmployeeTest.testBonus(), public void com.skillsoft.reflection.EmployeeTest.testGetters(), public void com.skillsoft.reflection.EmployeeTest.testSetters()]
        //
        //---------------
        //Found setup method: public void com.skillsoft.reflection.EmployeeTest.setup()
        //Found teardown method: public void com.skillsoft.reflection.EmployeeTest.teardown()
        //Found testcase method: [public void com.skillsoft.reflection.EmployeeTest.testBonus(), public void com.skillsoft.reflection.EmployeeTest.testGetters(), public void com.skillsoft.reflection.EmployeeTest.testSetters(), public void com.skillsoft.reflection.EmployeeTest.testIncrementSalary()]
        //
        //----------------
        //
        //----------- Starting tests
        //***Setup complete
        //***testBonus()
        //110000.00014901161
        //Testcase failed:-( public void com.skillsoft.reflection.EmployeeTest.testBonus()
        //***Teardown complete
        //***Setup complete
        //***testGetters()
        //Testcase failed:-( public void com.skillsoft.reflection.EmployeeTest.testGetters()
        //***Teardown complete
        //***Setup complete
        //***testSetters()
        //Testcase failed:-( public void com.skillsoft.reflection.EmployeeTest.testSetters()
        //***Teardown complete
        //***Setup complete
        //***testIncrementSalary()
        //Testcase failed:-( public void com.skillsoft.reflection.EmployeeTest.testIncrementSalary()
        //***Teardown complete
        //------------- Test completed
        //The following test cases failed
        //testBonus
        //testGetters
        //testSetters
        //testIncrementSalary
    }
}

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
// Java docs for java.lang.reflect.InvocationHandler

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
// Java docs for java.lang.reflect.Proxy, the superclass for dynamic proxy classes