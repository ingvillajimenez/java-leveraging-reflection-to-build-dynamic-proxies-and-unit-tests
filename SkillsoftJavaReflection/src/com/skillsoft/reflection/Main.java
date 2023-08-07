package com.skillsoft.reflection;

import java.lang.reflect.Proxy; // class Proxy
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        List proxyList = (List) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] {List.class},
                new ListInvocationHandler(list)
        );

        proxyList.add("Java");
        System.out.println(list); // [Java]

        proxyList.add("Python");
        System.out.println(list); // [Java, Python]

        proxyList.add("C++");
        proxyList.add("C#");
        proxyList.add("JavaScript");
        System.out.println(list); // [Java, Python, C++, C#, JavaScript]

        System.out.println();

        proxyList.remove("Java");
        System.out.println(list); // [Python, C++, C#, JavaScript]

        proxyList.remove("JavaScript");
        System.out.println(list); // [Python, C++, C#]

        System.out.println();

        System.out.println("index 2: " + proxyList.get(2)); // index 2: C#
        System.out.println("index 0: " + proxyList.get(0)); // index 0: Python

//        List proxyList = (List) Proxy.newProxyInstance( // Raw use of parameterized class 'List'
//                Main.class.getClassLoader(),
//                new Class[]{List.class},
//                new SimplePrintInvocationHandler()
//        );
//
//        System.out.println();
//
//        proxyList.add("Java"); // Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
//        //Proxy: class com.sun.proxy.$Proxy0
//        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
//        //Arguments: [Java]
//
//        System.out.println();
//
//        proxyList.clear();
//        //Proxy: class com.sun.proxy.$Proxy0
//        //Method invoked: public abstract void java.util.List.clear()
//        //Arguments: null
//
//        System.out.println();
//
//        proxyList.remove(1234);
//        //Proxy: class com.sun.proxy.$Proxy0
//        //Method invoked: public abstract java.lang.Object java.util.List.remove(int)
//        //Arguments: [1234]
    }
}

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
// Java docs for java.lang.reflect.InvocationHandler

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
// Java docs for java.lang.reflect.Proxy, the superclass for dynamic proxy classes