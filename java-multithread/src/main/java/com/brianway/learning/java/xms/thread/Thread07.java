package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class Thread07 extends Thread {
    public Thread07(){
        System.out.println("Thread05 begin :");
        System.out.println(" thread currentThread name : " + Thread.currentThread().getName());
        System.out.println("this.getName() : " + this.getName());
        System.out.println("this.isAlive() : " + this.isAlive());
        System.out.println("Thread05 end :");
    }

    @Override
    public void run() {
        System.out.println("run begin :");
        System.out.println(" thread currentThread name : " + Thread.currentThread().getName());
        System.out.println("this.getName() : " + this.getName());
        System.out.println("this.isAlive() : " + this.isAlive());
        System.out.println("run end :");
    }
}
