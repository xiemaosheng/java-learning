package com.brianway.learning.java.xms.waitAndNotify.pipInputAndOutStream;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write :");
            for (int i =0;i<300;i++){
                String outData = "" + (i+1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
