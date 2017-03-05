package com.brianway.learning.java.base.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理（从字节码层面 动态生成代理类）
 * Created by xms on 2017/3/5 0005.
 */
public class CGLibProxy implements MethodInterceptor {

    private CGLibProxy() {
    }

    /**
     * 内部类维护单例的实现，JVM内部机制能够保证一个类被加载的时候，这个类加载的过程是线程互斥的
     */
    private static class SingletonFactory {
        private static CGLibProxy instance = new CGLibProxy();
    }

    public static CGLibProxy getInstance() {
        return SingletonFactory.instance;
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = methodProxy.invokeSuper(o, objects);

        return result;
    }
}
