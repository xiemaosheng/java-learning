package com.brianway.learning.java.xms.test;

import com.brianway.learning.java.xms.thread.ThreadSuspend02;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class TestThreadSuspend02 {
    public static void main(String[] args) {
        try {
            ThreadSuspend02 suspend02 = new ThreadSuspend02();
            suspend02.start();
            Thread.sleep(1000);
            suspend02.suspend();
            suspend02.resume();
            System.out.println("main end:");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
