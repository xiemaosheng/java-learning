package com.brianway.learning.java.xms.synchronize.stringAndSyn;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class StringThread01 extends Thread{
    private StringService stringService;

    public StringThread01(StringService stringService){
        this.stringService = stringService;
    }

    @Override
    public void run() {
        stringService.printStatic("String");
    }
}
