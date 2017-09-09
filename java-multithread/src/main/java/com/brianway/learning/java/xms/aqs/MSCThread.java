package com.brianway.learning.java.xms.aqs;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MSCThread implements Runnable {
    private static MSCLock lock = new MSCLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getId() + "获取锁执行");
        lock.unlock();
    }
}
