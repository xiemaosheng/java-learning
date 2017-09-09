package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/**
 * CLH 阻塞锁
 * Created by Administrator on 2017/9/8 0008.
 */
public class BlockCLHLock {
    public static class CLHNode{
        private volatile Thread isLocked;
    }

    @SuppressWarnings("usused")
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> local = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<BlockCLHLock,CLHNode> update = AtomicReferenceFieldUpdater.newUpdater(BlockCLHLock.class,CLHNode.class,"tail");

    public void lock(){
        CLHNode node = new CLHNode();
        local.set(node);
        CLHNode preNode = update.getAndSet(this,node);
        if (preNode != null){
            preNode.isLocked = Thread.currentThread();
            LockSupport.park(this);
            preNode = null;
            local.set(node);
        }
    }

    public void unlock(){
        CLHNode node = local.get();
        if (!update.compareAndSet(this,node,null)){
            System.out.println("解锁："+node.isLocked.getId());
            LockSupport.unpark(node.isLocked);
        }
        node = null;
    }
}
