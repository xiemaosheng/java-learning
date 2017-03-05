package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt04 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for(int i = 0 ; i < 100000 ; i ++){
                System.out.println("i = " + (i + 1));
            }
            System.out.println("run begin:");
            Thread.sleep(200000);
            System.out.println("run end :");
        }catch (InterruptedException e){
            System.out.println("先停止，遇到sleep后！进入catch + " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
