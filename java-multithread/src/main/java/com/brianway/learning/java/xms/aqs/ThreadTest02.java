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
        testA();
        lock.unlock();
    }

    public void testA() {
        lock.lock();
        System.out.println("test:" + Thread.currentThread().getId());
        testB();
        lock.unlock();
    }

    public void testB() {
        lock.lock();
        System.out.println("test:" + Thread.currentThread().getId());
        lock.unlock();
    }
}
