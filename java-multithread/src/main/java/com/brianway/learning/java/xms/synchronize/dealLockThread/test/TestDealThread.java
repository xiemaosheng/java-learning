package com.brianway.learning.java.xms.synchronize.dealLockThread.test;

import com.brianway.learning.java.multithread.synchronize.example12.DealThread;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class TestDealThread {
    public static void main(String[] args) {
        /**
         * 死锁情况：
         * 排查：利用工具：jps 查看所有Java进程pid命令；
         * jstack 命令： 查看给定Java进程ID 或core file 或 远程调式服务的Java堆栈信息
         */
        try {
            DealThread dealThread = new DealThread();
            dealThread.setFlag("a");
            Thread thread = new Thread(dealThread);
            thread.start();
            Thread.sleep(1000);
            dealThread.setFlag("b");
            Thread thread1 = new Thread(dealThread);
            thread1.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
