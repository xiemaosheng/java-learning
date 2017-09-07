package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单非重入互斥锁的实现
 * Created by Administrator on 2017/7/31 0031.
 */
public class SimpleLock extends AbstractQueuedSynchronizer {
    private static final long serialVersionUID = -7316320116933187634L;

    public SimpleLock() {

    }

    protected boolean tryAcquire(int unused) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    protected boolean tryRelease(int unused) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public boolean tryLock() {
        return tryAcquire(1);
    }

    public void unlock() {
        release(1);
    }

    public boolean isLocked() {
        return isHeldExclusively();
    }

    public static void main(String[] args) throws Exception {
        // 简单非重入锁实现
        final SimpleLock simpleLock = new SimpleLock();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                simpleLock.lock();
                System.out.println(Thread.currentThread().getId() + " simpleLock acquired the lock!");
                simpleLock.unlock();
            }
        });

        System.out.println("main thread unlock!");

        // 可重入锁
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId() + " ReentrantLock acquired the lock!");
                    lock.unlock();
                }
            }).start();
            // 简单的让线程按照for循环的顺序阻塞在lock上
            Thread.sleep(100);
        }
    }

}
