package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class ThreadStaticSyn03 extends Thread{
    private Service service;

    public ThreadStaticSyn03(Service service){
        this.service = service;
    }
    @Override
    public void run() {
        service.printA();
    }
}
