package com.yuxuan66;

import java.lang.reflect.InvocationTargetException;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if ("com.yuxuan66.HelloWorld".equals(name)) {
            byte[] data = HelloWorldDump.dump();
            return defineClass(name, data, 0, data.length);
        }
        throw new ClassNotFoundException("Class Not Found:" + name);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = new MyClassLoader().findClass("com.yuxuan66.HelloWorld");
        Object obj = clazz.newInstance();
        System.out.println(clazz.getMethod("toString").invoke(obj));;
    }
}
