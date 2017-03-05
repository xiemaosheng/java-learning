package com.brianway.learning.java.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理
 * Created by xms on 2017/3/5 0005.
 */
public class DynamicProxy01 implements InvocationHandler {
    private Object target;

    public DynamicProxy01(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行方法前操作

        Object result = method.invoke(target,args);

        // 执行方法后操作

        return result;
    }
}
