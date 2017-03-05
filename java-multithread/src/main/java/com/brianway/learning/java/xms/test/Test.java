package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.MyThread;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class Test {
    public static void main(String args[]) {
        try {
            MyThread thread = new MyThread();
            thread.setName("myThread");
            thread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run : " + Thread.currentThread().getName() + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
