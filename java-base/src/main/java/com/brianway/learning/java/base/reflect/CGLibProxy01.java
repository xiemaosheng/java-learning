package com.brianway.learning.java.base.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理（从字节码层面 动态生成代理类）
 * Created by xms on 2017/3/5 0005.
 */
public class CGLibProxy01 implements MethodInterceptor {
    private static CGLibProxy01 instance = null;

    private CGLibProxy01() {
    }

    private static CGLibProxy01 init(){
        if (null == instance){
            synchronized (instance){
                instance = new CGLibProxy01();
            }
        }
        return instance;
    }

    /**
     * 影子实例:有问题
     * @return
     */
    public static CGLibProxy01 getInstance(){
        if (null == instance){
            return init();
        }
        return instance;
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
