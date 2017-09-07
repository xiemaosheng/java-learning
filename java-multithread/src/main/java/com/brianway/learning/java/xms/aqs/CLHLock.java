package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class CLHLock {
    public static class CLHNode {
        private volatile boolean isLocked = true;
    }

    @SuppressWarnings("unused")
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> local = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> update = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");

    public void lock() {
        CLHNode node = new CLHNode();
        local.set(node);
        CLHNode preNode = update.getAndSet(this, node);

        System.out.println(Thread.currentThread().getId() + "(获取锁)当前节点：" + node.toString());
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }

        if (preNode != null) {
            System.out.println(Thread.currentThread().getId() + "(获取锁)当前前驱节点：" + preNode.toString());
        } else {
            System.out.println(Thread.currentThread().getId() + "(率先获取锁)当前前驱节点：" + null);
        }
        if (preNode != null) {
            while (preNode.isLocked) {
                System.out.println("线程" + Thread.currentThread().getId() + "自旋");
                try {
                    Thread.sleep(5000);
                }catch (Exception e){

                }
            }
            preNode = null;
            local.set(node);
        }
    }

    public void unlock() {
        CLHNode node = local.get();
        System.out.println(Thread.currentThread().getId() + "(解锁)当前节点：" + node.toString());
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        if (!update.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CLHThread());
        Thread thread2 = new Thread(new CLHThread());
        Thread thread3 = new Thread(new CLHThread());
        Thread thread4 = new Thread(new CLHThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
