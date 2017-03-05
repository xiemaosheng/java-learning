package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadSuspend02 extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while(i<1000000){
            i ++;
            synchronized (new Object()){
                System.out.println(i);
            }
        }
    }
}
