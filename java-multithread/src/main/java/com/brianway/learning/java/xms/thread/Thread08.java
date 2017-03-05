package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class Thread08 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName = " + this.currentThread().getName() + "begin:");
            this.sleep(10000);
            System.out.println("run threadName = " + this.currentThread().getName() + "end:");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
