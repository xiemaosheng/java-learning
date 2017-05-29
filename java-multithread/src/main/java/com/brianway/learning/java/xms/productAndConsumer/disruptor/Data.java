package com.brianway.learning.java.xms.productAndConsumer.disruptor;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Data {
    private long value;

    public Data() {
    }

    public Data(long vaule) {
        this.value = vaule;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
