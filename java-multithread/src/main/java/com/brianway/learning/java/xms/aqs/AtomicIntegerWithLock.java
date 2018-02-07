package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock和synchronized 锁实现原子操作
 * Created by Administrator on 2017/9/10 0010.
 */
public class AtomicIntegerWithLock {
    private int value;
    private Lock lock = new ReentrantLock();

    public AtomicIntegerWithLock(int value) {
        this.value = value;
    }

    public AtomicIntegerWithLock() {
        super();
    }

    public final int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    public final void set(int newValue) {
        lock.lock();
        try {
            value = newValue;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndSet(int newValue) {
        lock.lock();
        try {
            int ret = value;
            value = newValue;
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public final boolean compareAndSet(int expect, int newValue) {
        lock.lock();
        try {
            if (expect == value) {
                value = newValue;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndIncrement() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndDecrement() {
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public final int decrementAndGet() {
        lock.lock();
        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "AtomicIntegerWithLock{" +
                "value=" + value +
                ", lock=" + lock +
                '}';
    }

    public static void main(String[] args) throws Exception {
        final int max = 10;
        final int loopCount = 100000;

        long costTime = 0;
        final AtomicIntegerWithLock value0 = new AtomicIntegerWithLock(0);
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for (int i = 0; i < max; i++) {
                ts[i] = new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            value0.incrementAndGet();
                        }
                    }
                };
            }
            for (Thread t : ts) {
                t.start();
            }
            for (Thread t : ts) {
                t.join();
            }
            long endTime = System.nanoTime();
            costTime += (endTime - start1);

        }
        System.out.println("costTime:" + costTime);
        System.out.println("value:" + value0.get());


        System.out.println("*******************************************************");
        costTime = 0;

        //
        final Object lock = new Object();
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread() {
                    public void run() {
                        for (int i = 0; i < loopCount; i++) {
                            synchronized(lock) {
                                ++staticValue;
                            }
                        }
                    }
                };
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        //
        System.out.println("cost2: " + (costTime));
        System.out.println("staticValue: " + (staticValue));
    }

    static int staticValue=0;

}
