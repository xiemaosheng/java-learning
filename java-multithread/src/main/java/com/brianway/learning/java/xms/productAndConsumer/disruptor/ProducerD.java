package com.brianway.learning.java.xms.productAndConsumer.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class ProducerD {
    private final RingBuffer<Data> ringBuffer ;

    public ProducerD(RingBuffer<Data> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer byteBuffer){
        long sequence = ringBuffer.next();
        try {
            Data data = ringBuffer.get(sequence);
            data.setValue(byteBuffer.getLong(0));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
