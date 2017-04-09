package com.brianway.learning.java.xms.ReentrantLock.test;

import com.brianway.learning.java.xms.ReentrantLock.LockService;
import com.brianway.learning.java.xms.ReentrantLock.LockThread;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class RunTest {
    public static void main(String[] args) {
        LockService lockService = new LockService();

        LockThread lockThread1 = new LockThread(lockService);
        LockThread lockThread2 = new LockThread(lockService);
        LockThread lockThread3 = new LockThread(lockService);
        LockThread lockThread4 = new LockThread(lockService);
        LockThread lockThread5 = new LockThread(lockService);
        lockThread1.start();
        lockThread2.start();
        lockThread3.start();
        lockThread4.start();
        lockThread5.start();

    }
}
