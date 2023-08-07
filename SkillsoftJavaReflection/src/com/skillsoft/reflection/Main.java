package com.skillsoft.reflection;

import java.lang.reflect.Proxy; // class Proxy

public class Main {
    public static void main(String[] args) {

        Repository proxyRepository = (Repository) Proxy.newProxyInstance(
          Main.class.getClassLoader(),
          new Class[] {Repository.class},
          new SimplePrintInvocationHandler()
        );

        System.out.println();

        proxyRepository.create("Hello");
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public abstract void com.skillsoft.reflection.Repository.create(java.lang.Object)
        //Arguments: [Hello]

        System.out.println();

        proxyRepository.read(12345);
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public abstract java.lang.Object com.skillsoft.reflection.Repository.read(int)
        //Arguments: [12345]

    }
}

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
// Java docs for java.lang.reflect.InvocationHandler

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
// Java docs for java.lang.reflect.Proxy, the superclass for dynamic proxy classes