package com.brianway.learning.java.multithread.synchronize.example6;

/**
 * Created by Brian on 2016/4/12.
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(String name, Service service) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
