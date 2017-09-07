package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：支持可重入
 * Created by Administrator on 2017/9/7 0007.
 */
public class SpinLock02 {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private int count = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            count++;
            System.out.println(current.getId() + "重入" + count + "次");
            return;
        }
        while (!owner.compareAndSet(null, current)) {
            System.out.println(current.getId() + "自旋");
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (count != 0) {
                count--;
                System.out.println(current.getId() + "锁数量减少至" + count);
            } else {
                owner.compareAndSet(current, null);
                System.out.println(current.getId() + "解锁");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadTest02());
        Thread thread2 = new Thread(new ThreadTest02());
        Thread thread3 = new Thread(new ThreadTest02());
        Thread thread4 = new Thread(new ThreadTest02());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
