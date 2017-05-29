package com.brianway.learning.java.xms.productAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;          // 内存缓冲区
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();

        System.out.println("start producer id = " +Thread.currentThread().getId());
        try {
            Thread.sleep(SLEEPTIME);
            data = new PCData(count.incrementAndGet());
            System.out.println(data + "is put into queue");
            if (!queue.offer(data,2, TimeUnit.SECONDS)){                 // 提交数据到缓冲区中
                System.out.println("failed to put data : " + data);
            }
        }catch (Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
