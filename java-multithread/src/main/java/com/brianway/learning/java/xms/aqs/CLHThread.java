package com.brianway.learning.java.xms.aqs;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class CLHThread implements Runnable {
    private static CLHLock lock = new CLHLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println("线程："+Thread.currentThread().getId()+"获取锁");
        lock.unlock();
    }
}
