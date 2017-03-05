package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt03 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin:");
            Thread.sleep(200000);
        }catch (InterruptedException e){
            System.out.println("在sleep中被停止： 进入catch！"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
