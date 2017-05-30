package com.brianway.learning.java.xms.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(1);
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                    System.out.println(2);
                    Thread.sleep(2000);
                    countDownLatch.countDown();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();

        countDownLatch.await();
        System.out.println(3);
    }
}
