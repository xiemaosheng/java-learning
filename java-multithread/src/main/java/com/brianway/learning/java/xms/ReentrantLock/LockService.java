package com.brianway.learning.java.xms.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class LockService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }
}
