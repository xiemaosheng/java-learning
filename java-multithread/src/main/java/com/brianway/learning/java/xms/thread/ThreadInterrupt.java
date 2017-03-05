package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 50000; i++){
                System.out.println("i=" + (i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
