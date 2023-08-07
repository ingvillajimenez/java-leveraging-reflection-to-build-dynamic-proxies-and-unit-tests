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

        System.out.println();

        proxyRepository.update("World");
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public abstract void com.skillsoft.reflection.Repository.update(java.lang.Object)
        //Arguments: [World]

        System.out.println();

        proxyRepository.delete(67890);
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public abstract void com.skillsoft.reflection.Repository.delete(int)
        //Arguments: [67890]

        System.out.println();

        proxyRepository.toString(); // Result of 'Object.toString()' is ignored
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public java.lang.String java.lang.Object.toString()
        //Arguments: null

        System.out.println();

        System.out.println(proxyRepository);
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public java.lang.String java.lang.Object.toString()
        //Arguments: null
        //--------------
        //Any return value is fine here

        System.out.println();

        proxyRepository.hashCode(); // Result of 'Object.hashCode()' is ignored
        //Proxy: class com.sun.proxy.$Proxy0
        //Method invoked: public native int java.lang.Object.hashCode()
        //Arguments: null
        //java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
    }
}

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
// Java docs for java.lang.reflect.InvocationHandler

// https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
// Java docs for java.lang.reflect.Proxy, the superclass for dynamic proxy classes