package com.brianway.learning.java.xms.aqs;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class ThreadTest02 implements Runnable {
    private static SpinLock02 lock = new SpinLock02();

    @Override
    public void run() {
        lock.lock();
        System.out.println("run:" + Thread.currentThread().getId());
        test();
        lock.unlock();
    }

    public void test() {
        lock.lock();
        System.out.println("test:" + Thread.currentThread().getId());
        lock.unlock();
    }
}
