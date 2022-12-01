package com.yuxuan66;

public class Demo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<?> clazz = new HelloWorldProxyFactory().getProxyClass();
        HelloWorld helloWorld = (HelloWorld) clazz.newInstance();
        helloWorld.test();
    }
}
