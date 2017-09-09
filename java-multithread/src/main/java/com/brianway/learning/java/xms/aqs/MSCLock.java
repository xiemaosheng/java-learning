package com.brianway.learning.java.xms.aqs;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MSCLock {
    public static class MSCNode {
        volatile MSCNode next;
        volatile boolean isLocked = true;
    }

    private static final ThreadLocal<MSCNode> node = new ThreadLocal<>();
    @SuppressWarnings("unused")
    private volatile MSCNode queue;
    private static final AtomicReferenceFieldUpdater<MSCLock, MSCNode> update = AtomicReferenceFieldUpdater.newUpdater(MSCLock.class, MSCNode.class, "queue");

    public void lock() {
        MSCNode currentNode = new MSCNode();
        node.set(currentNode);
        MSCNode preNode = update.getAndSet(this, currentNode);
        System.out.println(Thread.currentThread().getId() + "(获取锁)当前节点：" + currentNode.toString());
        if (preNode == null){
            System.out.println(Thread.currentThread().getId() + "(率先获取锁)前驱节点：" + null);
        }else {
            System.out.println(Thread.currentThread().getId() + "(获取锁)前驱节点：" + null);
        }
        if (preNode != null) {
            preNode.next = currentNode;
            while (currentNode.isLocked) {
                System.out.println(Thread.currentThread().getId() + "自旋");
            }
        }
    }

    public void unlock() {
        MSCNode currentNode = node.get();
        if (currentNode == null){
            System.out.println(Thread.currentThread().getId() + "(解锁)当前节点：" + null);
        }else {
            System.out.println(Thread.currentThread().getId() + "(解锁)当前节点：" + currentNode.toString());
        }
        if (currentNode.next == null) {
            System.out.println(Thread.currentThread().getId() + "下一个节点：" + null);
            if (update.compareAndSet(this, currentNode, null)) {

            } else {
                while (currentNode.next == null) {

                }
            }
        } else {
            System.out.println(Thread.currentThread().getId() + "下一个节点：" + currentNode.next.toString());
            currentNode.next.isLocked = false;
            currentNode.next = null;
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MSCThread());
        Thread thread2 = new Thread(new MSCThread());
        Thread thread3 = new Thread(new MSCThread());
        Thread thread4 = new Thread(new MSCThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
