package com.brianway.learning.java.xms.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class LockConditionService {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            conditionA.await();
            System.out.println("beign awaitA 时间为：" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            conditionB.await();
            System.out.println("beign awaitB 时间为：" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signAllA(){
        try {
            lock.lock();
            System.out.println(" signAllA 时间为" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void signAllB(){
        try {
            lock.lock();
            System.out.println(" signAllB 时间为" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
