package com.brianway.learning.java.xms.productAndConsumer.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class DataFactory implements EventFactory<Data> {
    public Data newInstance(){
        return new Data();
    }
}
