package com.gorbatenko.rabbitmq.receive;

public class Receiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}