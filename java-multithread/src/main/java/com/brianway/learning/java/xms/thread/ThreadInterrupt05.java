package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt05 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
