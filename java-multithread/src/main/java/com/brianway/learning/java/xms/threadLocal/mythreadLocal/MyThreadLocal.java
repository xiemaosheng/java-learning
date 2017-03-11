package com.brianway.learning.java.xms.threadLocal.mythreadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 手写简单的ThreadLocal
 * Created by xms on 2017/3/11 0011.
 */
public class MyThreadLocal<T> {
    // 有条件的线程安全-------所有单个操作都是线程安全的
    private Map<Thread,T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    protected T initialValue(){
        return null;
    }

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (null == value && !container.containsKey(thread)){
            value = initialValue();
            container.put(thread,value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }
}
