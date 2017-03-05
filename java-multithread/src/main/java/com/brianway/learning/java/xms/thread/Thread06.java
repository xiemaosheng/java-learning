package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class Thread06 extends Thread {
    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }
}
