package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class MyThread06 extends Thread{
    private Object object;
    private ObjectService01 objectService01;

    public MyThread06(ObjectService01 objectService01,Object object){
        this.object = object;
        this.objectService01 = objectService01;
    }

    @Override
    public void run() {
        super.run();
        objectService01.testMethod1(object);
    }
}
