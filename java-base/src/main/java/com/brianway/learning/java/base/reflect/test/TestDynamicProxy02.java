package com.brianway.learning.java.base.reflect.test;

import com.brianway.learning.java.base.reflect.DynamicProxy02;
import com.brianway.learning.java.base.reflect.hello.Hello;
import com.brianway.learning.java.base.reflect.hello.HelloImpl;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestDynamicProxy02 {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy02 dynamicProxy = new DynamicProxy02(hello);

        Hello helloProxy = dynamicProxy.getProxy();

        helloProxy.say("xms");
    }
}
