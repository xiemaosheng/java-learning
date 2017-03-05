package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class MyThread01 extends Thread {
    private int i;
    public MyThread01(int i){
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
