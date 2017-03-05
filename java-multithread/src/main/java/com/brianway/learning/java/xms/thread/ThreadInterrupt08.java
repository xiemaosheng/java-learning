package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt08 extends Thread {
    @Override
    public void run() {
        super.run();
        while(true){
            if(this.isInterrupted()){
                System.out.println("停止了");
                return;
            }
            System.out.println("timer =" + System.currentTimeMillis());
        }
    }
}
