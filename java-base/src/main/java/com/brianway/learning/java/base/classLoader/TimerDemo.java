package com.brianway.learning.java.base.classLoader;

import java.lang.reflect.Method;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class TimerDemo extends TimerTask {
    protected TimerDemo() {
        super();
    }

    @Override
    public void run() {
        try {
            // 每次都创建一个新的类加载器（有待优化）
            HotSwapCL hotSwapCL = new HotSwapCL("F:\\git\\test\\java-learning\\java-base\\target\\classes",new String[]{"com.brianway.learning.java.base.classLoader.Demo"});
            Class clz = hotSwapCL.loadClass("com.brianway.learning.java.base.classLoader.Demo");
            Object demo = clz.newInstance();
            Method m = demo.getClass().getMethod("sayHello",new Class[]{});
            m.invoke(demo,new Object[]{});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
