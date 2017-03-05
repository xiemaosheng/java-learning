package com.brianway.learning.java.base.reflect.test;

import com.brianway.learning.java.base.reflect.CGLibProxy;
import com.brianway.learning.java.base.reflect.hello.HelloImpl;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestCGLib {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = CGLibProxy.getInstance();
        HelloImpl helloProxy = cgLibProxy.getProxy(HelloImpl.class);

        helloProxy.say("xms");
    }
}
