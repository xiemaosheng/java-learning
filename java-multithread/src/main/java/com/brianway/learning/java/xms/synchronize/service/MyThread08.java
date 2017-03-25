package com.brianway.learning.java.xms.synchronize.service;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class MyThread08 extends Thread{
    private MyObject myObject;
    private Service service;

    public MyThread08(MyObject myObject, Service service){
        this.myObject = myObject;
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.test(myObject);
    }
}
