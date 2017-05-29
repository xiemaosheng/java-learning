package com.brianway.learning.java.xms.productAndConsumer.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Consumer implements WorkHandler<Data> {
    @Override
    public void onEvent(Data data) throws Exception {
        System.out.println(Thread.currentThread().getId() + ":Event:--"+ data.getValue() * data.getValue() + "--");
    }
}
