package com.brianway.learning.java.base.reflect.test;

import com.brianway.learning.java.base.reflect.CGLibProxy01;
import com.brianway.learning.java.base.reflect.hello.HelloImpl;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestCGLib01 {
    public static void main(String[] args) {
        CGLibProxy01 cgLibProxy = CGLibProxy01.getInstance();
        HelloImpl helloProxy = cgLibProxy.getProxy(HelloImpl.class);

        helloProxy.say("xms");
    }
}
