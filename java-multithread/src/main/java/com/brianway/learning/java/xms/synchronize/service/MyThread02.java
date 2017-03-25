package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class MyThread02 extends Thread{
    private ObjectService objectServcie;
    public MyThread02(ObjectService objectServcie){
        super();
        this.objectServcie = objectServcie;
    }

    @Override
    public void run() {
        super.run();
        objectServcie.test();
    }
}
