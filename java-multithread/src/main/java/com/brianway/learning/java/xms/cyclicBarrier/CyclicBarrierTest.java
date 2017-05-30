package com.brianway.learning.java.xms.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 让一组线程到达一个屏障（同步点）时被阻塞，知道最后一个线程到达屏障时，屏障才会开门，所有别屏障拦截的线程才会继续执行
 * Created by Administrator on 2017/5/30 0030.
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(2);
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }

}
