package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class Service {
    public void test(MyObject myObject) {
        synchronized (myObject) {
            try {
                System.out.println("testMethod1 __getLock Time = " +
                        System.currentTimeMillis() + " run ThreadName=" +
                        Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time=" +
                        System.currentTimeMillis() + " run ThreadName=" +
                        Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printA");
            Thread.sleep(2000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printB");
            Thread.sleep(2000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void printC() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printC");
            Thread.sleep(2000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printD(){
        synchronized (Service.class){
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printD");
                Thread.sleep(2000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printD");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void printF(){
        synchronized (Service.class){
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 进入printF");
                Thread.sleep(2000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + " 离开printF");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
