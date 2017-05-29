package com.brianway.learning.java.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class HelloWorld extends UntypedActor {

    private ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter Actor Path : " + greeter.path());
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Greeter.Msg.DONE){
            greeter.tell(msg,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(msg);
        }
    }
}
