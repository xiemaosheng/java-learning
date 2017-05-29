package com.brianway.learning.java.xms.productAndConsumer.disruptor;

import com.brianway.learning.java.xms.productAndConsumer.*;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newCachedThreadPool();
        DataFactory dataFactory = new DataFactory();

        int bufferSize = 1024;

        Disruptor<Data> disruptor = new Disruptor<Data>(dataFactory,bufferSize,executor, ProducerType.MULTI,new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(new Consumer(),new Consumer(),new Consumer(),new Consumer());

        disruptor.start();

        RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();

        ProducerD producerD = new ProducerD(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long i = 0; true;i++){
            byteBuffer.putLong(0,i);
            producerD.pushData(byteBuffer);
            Thread.sleep(100);
            System.out.println("add data " + i);
        }


    }
}
