package com.brianway.learning.java.xms.aqs;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class TicketThread implements Runnable {
    private static TicketLock lock = new TicketLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getId() + "获取锁");
        lock.unlock();
    }
}
