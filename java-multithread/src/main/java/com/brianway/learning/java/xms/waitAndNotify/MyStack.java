package com.brianway.learning.java.xms.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class MyStack {
    private List list = new ArrayList();

    public synchronized void push(){
        try{
            if (list.size() == 1){
                this.wait();
            }
            list.add("anyString=" + Math.random());
            this.notify();
            System.out.println("push=" + list.size());
        }catch (Exception e){

        }
    }

    public synchronized String pop(){
        String returnString = "";
        try {
            if (list.size() == 0){
                this.wait();
            }
            returnString = "" + list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop = " + list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnString;
    }
}
