package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadSuspend01 extends Thread {
    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    private long i = 0;

    @Override
    public void run() {
        while (true){
            i++;
        }
    }
}
