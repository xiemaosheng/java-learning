package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class Thread09 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName = " + this.currentThread().getName() + "begin:" + System.currentTimeMillis());
            Thread.sleep(10000);
            System.out.println("run threadName = " + this.currentThread().getName() + "end:" + System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
