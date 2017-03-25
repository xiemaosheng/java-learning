package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class ThreadStaticSyn01 extends Thread{
    @Override
    public void run() {
        Service.printA();
    }
}
