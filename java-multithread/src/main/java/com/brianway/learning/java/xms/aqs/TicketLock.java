package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁:场景：解决顺序访问的问题，多核CPU上
 * Created by Administrator on 2017/9/7 0007.
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> local = new ThreadLocal<>();

    public void lock() {
        int myticket = ticketNum.getAndIncrement();
        local.set(myticket);
        while (myticket != serviceNum.get()) {
            System.out.println(Thread.currentThread().getId() + "自旋,当前ticketNum:" + myticket);
            System.out.println(Thread.currentThread().getId() + "自旋，当前serviceNum:" + serviceNum.get());
        }
    }

    public void unlock() {
        int myticket = local.get();
        serviceNum.compareAndSet(myticket, myticket + 1);
        System.out.println(Thread.currentThread().getId() + "解锁,当前ticketNum:" + myticket + ",解锁后serviceNum会自增：" + (myticket + 1));
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TicketThread());
        Thread thread2 = new Thread(new TicketThread());
        Thread thread3 = new Thread(new TicketThread());
        Thread thread4 = new Thread(new TicketThread());
        Thread thread5 = new Thread(new TicketThread());
        Thread thread6 = new Thread(new TicketThread());
        Thread thread7 = new Thread(new TicketThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
