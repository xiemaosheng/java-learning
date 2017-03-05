package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadPriority01 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadPriority01 run priority = " + this.getPriority());
        ThreadPriority02 priority02 = new ThreadPriority02();
        priority02.start();
    }
}
