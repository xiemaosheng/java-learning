package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class Thread03 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count --;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count = " + count);
    }
}
