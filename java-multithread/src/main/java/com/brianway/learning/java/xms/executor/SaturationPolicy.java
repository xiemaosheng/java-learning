package com.brianway.learning.java.xms.executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 -- 任务队列饱和策略
 * 1 new ThreadPoolExecutor.AbortPolicy()  --- 任务队列饱和时抛出异常RejectedExecutionException
 * 2 new ThreadPoolExecutor.CallerRunsPolicy()  --- 任务队列饱和时,将新加入的任务放到当前线程内执行,内部执行run方法
 * 3 new ThreadPoolExecutor.DiscardPolicy()  --- 任务队列饱和时抛弃新加的任务，内部不做任何处理
 * 4 new ThreadPoolExecutor.DiscardOldestPolicy() --- 任务队列饱和时丢掉最老任务，内部直接队列queue.poll()
 *
 * Created by xms on 2018/2/7 0007.
 */
public class SaturationPolicy {
    /**
     * 线程池工作队列已满时，在不同饱和策略下表现
     *
     * @param handler 线程池工作队列饱和策略
     */
    public static void policy(RejectedExecutionHandler handler) {
        //基本线程2个，最大线程数为3，工作队列容量为5
        ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 3, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(3));
        if (handler != null) {
            exec.setRejectedExecutionHandler(handler);//设置饱和策略
        }
        for (int i = 0; i < 10; i++) {
            exec.submit(new Task());//提交任务
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        // 任务队列饱和时抛出异常RejectedExecutionException
//        policy(new ThreadPoolExecutor.AbortPolicy());
        // 任务队列饱和时,将新加入的任务放到当前线程内执行,内部执行run方法
//        policy((new ThreadPoolExecutor.CallerRunsPolicy()));
        // 任务队列饱和时抛弃新加的任务，内部不做任何处理
//        policy(new ThreadPoolExecutor.DiscardPolicy());
        // 任务队列饱和时丢掉最老任务，内部直接队列queue.poll()
//        policy(new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    //自定义任务
    static class Task implements Runnable {
        private static int count = 0;
        private int id = 0;//任务标识

        public Task() {
            id = ++count;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);//休眠3秒
            } catch (InterruptedException e) {
                System.err.println("线程被中断" + e.getMessage());
            }
            System.out.println(" 任务：" + id + "\t 工作线程: " + Thread.currentThread().getName() + " 执行完毕");
        }
    }
}
