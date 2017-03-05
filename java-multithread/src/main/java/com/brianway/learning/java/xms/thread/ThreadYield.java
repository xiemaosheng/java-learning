package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadYield extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0 ; i < 1000000;i++){
            Thread.yield();
            count += i+1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时： " + (endTime - beginTime) + "毫秒! ");
    }
}
