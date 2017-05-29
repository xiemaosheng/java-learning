package com.brianway.learning.java.actor;

import akka.actor.UntypedActor;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Greeter extends UntypedActor {
    public static enum Msg{
        GREET,DONE
    }
    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Msg.GREET){
            System.out.println("Hello World!!");
            getSender().tell(Msg.DONE,getSelf());
        }else {
            unhandled(msg);
        }
    }
}
