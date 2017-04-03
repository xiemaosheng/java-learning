package com.brianway.learning.java.xms.waitAndNotify.join;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class JoinThread extends Thread {
    @Override
    public void run() {
        try {
            int value = (int) (Math.random() * 1000);
            System.out.println(value);
            Thread.sleep(value);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
