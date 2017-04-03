package com.brianway.learning.java.xms.waitAndNotify.pipInputAndOutStream;

import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class ThreadWrite extends Thread {

    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(WriteData writeData , PipedOutputStream outputStream){
        this.writeData = writeData;
        this.pipedOutputStream = outputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(pipedOutputStream);
    }
}
