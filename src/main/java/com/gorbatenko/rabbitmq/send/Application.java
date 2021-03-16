package com.gorbatenko.rabbitmq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Value("${rabbitmq.queueName}")
    private String queueName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int i = 0;
        while (true) {
            System.out.println("Waiting two seconds...");
            Thread.sleep(2000);
            i++;
            System.out.println("Sending message...[ " + i + " ]");
            rabbitTemplate.convertAndSend(queueName, "[ " + i + " ] Hello from RabbitMQ!");
        }
    }

}