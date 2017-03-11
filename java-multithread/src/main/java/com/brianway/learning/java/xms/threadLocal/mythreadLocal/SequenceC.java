package com.brianway.learning.java.xms.threadLocal.mythreadLocal;

import com.brianway.learning.java.xms.threadLocal.ClientThread;
import com.brianway.learning.java.xms.threadLocal.Sequence;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class SequenceC implements Sequence {
    private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceC();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
