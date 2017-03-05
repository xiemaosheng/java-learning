package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class MyThread02 extends Thread {
    private int count = 5;
    public MyThread02(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while(count > 0){
            count --;
            System.out.println("由 " + this.currentThread().getName() + " 计算，count = " + count);
        }
    }
}
