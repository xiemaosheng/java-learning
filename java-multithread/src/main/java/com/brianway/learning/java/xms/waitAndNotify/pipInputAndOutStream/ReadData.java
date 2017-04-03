package com.brianway.learning.java.xms.waitAndNotify.pipInputAndOutStream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class ReadData {
    public void readMethod(PipedInputStream inputStream){
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = inputStream.read(byteArray);
            while (readLength != -1){
                String newData = new String(byteArray,0,readLength);
                System.out.println(newData);
                readLength = inputStream.read(byteArray);
            }
            System.out.println();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
