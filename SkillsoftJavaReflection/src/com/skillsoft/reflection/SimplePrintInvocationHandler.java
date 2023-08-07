package com.skillsoft.reflection;

import java.lang.reflect.InvocationHandler; // interface InvocationHandler
import java.lang.reflect.Method; // class Method
import java.util.Arrays; // class Arrays

public class SimplePrintInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------");

        System.out.println("Proxy: " + proxy.getClass());
        // Proxy: class com.sun.proxy.$Proxy0
        // Proxy: class com.sun.proxy.$Proxy0
        // Proxy: class com.sun.proxy.$Proxy0
        System.out.println("Method invoked: " + method);
        // Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        // Method invoked: public abstract void java.util.List.clear()
        // Method invoked: public abstract java.lang.Object java.util.List.remove(int)
        System.out.println("Arguments: " + Arrays.toString(args));
        // Arguments: [Java]
        // Arguments: null
        // Arguments: [1234]

        System.out.println("--------------");

        return true;
    }
}
