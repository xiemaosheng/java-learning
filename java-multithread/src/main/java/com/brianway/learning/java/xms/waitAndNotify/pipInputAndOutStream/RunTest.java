package com.brianway.learning.java.xms.waitAndNotify.pipInputAndOutStream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            pipedOutputStream.connect(pipedInputStream);

            ThreadRead threadRead = new ThreadRead(readData,pipedInputStream);
            threadRead.start();
            Thread.sleep(3000);

            ThreadWrite threadWrite = new ThreadWrite(writeData,pipedOutputStream);
            threadWrite.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
