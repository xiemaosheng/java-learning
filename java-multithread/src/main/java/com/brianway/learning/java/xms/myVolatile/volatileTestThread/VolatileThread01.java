package com.brianway.learning.java.xms.myVolatile.volatileTestThread;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class VolatileThread01 extends Thread {
    public volatile static int count;
    private static void addCount(){
        for (int i =0;i<100;i++){
            count ++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        super.run();
        addCount();
    }
}
