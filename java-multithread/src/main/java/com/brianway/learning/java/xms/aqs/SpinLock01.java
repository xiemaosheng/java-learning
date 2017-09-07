package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁，不可重入
 * Created by Administrator on 2017/9/7 0007.
 */
public class SpinLock01 {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!owner.compareAndSet(null, current)) {
            System.out.println(current.getId() + "自旋");
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
        System.out.println(current.getId() + "解锁");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadTest01());
        Thread thread2 = new Thread(new ThreadTest01());
        Thread thread3 = new Thread(new ThreadTest01());
        Thread thread4 = new Thread(new ThreadTest01());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

}
