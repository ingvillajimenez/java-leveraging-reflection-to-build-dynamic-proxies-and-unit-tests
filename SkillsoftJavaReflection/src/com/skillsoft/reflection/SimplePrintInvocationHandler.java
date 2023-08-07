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
        // class com.sun.proxy.$Proxy0
        // class com.sun.proxy.$Proxy0
        // class com.sun.proxy.$Proxy0
        // class com.sun.proxy.$Proxy0
        System.out.println("Method invoked: " + method);
        // public abstract void com.skillsoft.reflection.Repository.create(java.lang.Object)
        // public abstract java.lang.Object com.skillsoft.reflection.Repository.read(int)
        // public abstract void com.skillsoft.reflection.Repository.update(java.lang.Object)
        // public abstract void com.skillsoft.reflection.Repository.delete(int)
        // public java.lang.String java.lang.Object.toString()
        // public native int java.lang.Object.hashCode()
        System.out.println("Arguments: " + Arrays.toString(args));
        // [Hello]
        // [12345]
        // [World]
        // [67890]
        // null
        // null

        System.out.println("--------------");

        return true; //Incompatible type might be returned when proxying method 'hashCode()': required: exactly Integer; got: exactly Boolean
//        return "Any return value is fine here";
    }
}
