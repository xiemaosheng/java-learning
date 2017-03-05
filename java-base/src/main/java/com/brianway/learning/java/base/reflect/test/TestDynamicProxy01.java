package com.brianway.learning.java.base.reflect.test;

import com.brianway.learning.java.base.reflect.DynamicProxy01;
import com.brianway.learning.java.base.reflect.hello.Hello;
import com.brianway.learning.java.base.reflect.hello.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestDynamicProxy01 {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy01 dynamicProxy = new DynamicProxy01(hello);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy
        );

        helloProxy.say("xms");
    }
}
