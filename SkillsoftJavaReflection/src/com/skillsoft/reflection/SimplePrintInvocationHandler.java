package com.skillsoft.reflection;

import java.lang.reflect.InvocationHandler; // interface InvocationHandler
import java.lang.reflect.Method; // class Method
import java.util.Arrays; // class Arrays

public class SimplePrintInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------");

        System.out.println("Proxy: " + proxy.getClass());
        // class com.sun.proxy.$Proxy0
        // class com.sun.proxy.$Proxy0
        System.out.println("Method invoked: " + method);
        // public abstract void com.skillsoft.reflection.Repository.create(java.lang.Object)
        // public abstract java.lang.Object com.skillsoft.reflection.Repository.read(int)
        System.out.println("Arguments: " + Arrays.toString(args));
        // [Hello]
        // [12345]

        System.out.println("--------------");

        return "Any return value is fine here";
    }
}
