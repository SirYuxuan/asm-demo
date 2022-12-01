package com.yuxuan66;

public class HelloWorldProxy extends HelloWorld{

    @Override
    public void test() {
        System.out.println("前置增强");
        super.test();
        System.out.println("后置增强");
    }
}
