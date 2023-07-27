package com.dange.tanmay.service;


import com.dange.tanmay.common.AccountEvent;
import com.dange.tanmay.common.InventoryEvent;
import com.dange.tanmay.common.OrderEvent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QueueSender {

        @Autowired
        private RabbitTemplate rabbitTemplate;

        @Autowired
        private Queue queue;

        public void send(InventoryEvent responseEvent) {
                System.out.println("Sending response");
                rabbitTemplate.convertAndSend(this.queue.getName(), responseEvent);
        }
}

