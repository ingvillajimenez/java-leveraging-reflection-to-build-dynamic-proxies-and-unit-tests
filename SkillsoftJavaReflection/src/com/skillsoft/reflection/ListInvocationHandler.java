package com.skillsoft.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ListInvocationHandler implements InvocationHandler {

    private final List<String> list;

    public ListInvocationHandler(List<String> list) {
        this.list = list;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------");

        System.out.println("Method invoked: " + method);
        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.add(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.remove(java.lang.Object)
        //Method invoked: public abstract boolean java.util.List.remove(java.lang.Object)
        //Method invoked: public abstract java.lang.Object java.util.List.get(int)
        //Method invoked: public abstract java.lang.Object java.util.List.get(int)
        System.out.println("Arguments: " + Arrays.toString(args));
        //Arguments: [Java]
        //Arguments: [Python]
        //Arguments: [C++]
        //Arguments: [C#]
        //Arguments: [JavaScript]
        //Arguments: [Java]
        //Arguments: [JavaScript]
        //Arguments: [2]
        //Arguments: [0]

        System.out.println("-----------------");

        return method.invoke(list, args);
    }
}
