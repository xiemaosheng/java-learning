package com.brianway.learning.java.xms.waitAndNotify.pipInputAndOutStream;

import java.io.PipedInputStream;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class ThreadRead extends Thread {

    private ReadData readData;
    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData , PipedInputStream pipedInputStream){
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}
