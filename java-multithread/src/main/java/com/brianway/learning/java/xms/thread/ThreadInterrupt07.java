package com.brianway.learning.java.xms.thread;

/**
 * Created by Administrator on 2017/2/26 0026.
 */
public class ThreadInterrupt07 extends Thread {
    private SynchronizedObject synchronizedObject;

    public ThreadInterrupt07(SynchronizedObject synchronizedObject) {
        super();
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        super.run();
        synchronizedObject.printString("b","bb");
    }
}
