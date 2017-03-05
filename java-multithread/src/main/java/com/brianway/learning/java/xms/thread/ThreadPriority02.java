package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadPriority02 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadPriority02 run priority = " + this.getPriority());
    }
}
