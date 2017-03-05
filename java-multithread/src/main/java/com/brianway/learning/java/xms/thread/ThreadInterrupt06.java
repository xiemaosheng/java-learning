package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt06 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            this.stop();
        }catch (ThreadDeath e){
            System.out.println("进入了catch方法！！");
            e.printStackTrace();
        }
    }
}
