package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run : " + Thread.currentThread().getName() + i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
