package com.brianway.learning.java.xms.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    // 线程池当前30个线程
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    // 最大并发量是10
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("save data :" + Thread.currentThread().getName());
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
