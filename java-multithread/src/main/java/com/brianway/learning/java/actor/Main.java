package com.brianway.learning.java.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("hello", ConfigFactory.load("samplehello.conf"));
        ActorRef actorRef = system.actorOf(Props.create(HelloWorld.class),"helloWorld");
        System.out.println("HelloWorld Actor Path : " + actorRef.path());
    }
}
