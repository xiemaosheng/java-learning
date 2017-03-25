package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class MyThread01 extends Thread{
    private ObjectService objectServcie;
    public MyThread01(ObjectService objectServcie){
        super();
        this.objectServcie = objectServcie;
    }

    @Override
    public void run() {
        super.run();
        objectServcie.serviceMethod();
    }
}
