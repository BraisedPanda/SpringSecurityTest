package com.braisedpanda.web.controller;

import com.braisedpanda.web.rabbitmq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: admin-dashboard
 * @description:
 * @author: chenzhen
 * @create: 2019-11-22 14:36
 **/
@RestController
public class RabbitMQController {
    @Autowired
    MessageSender messageConsumer;

    @RequestMapping("testRabbitMq")
    public void testRabbitMQ(){
        messageConsumer.testFanout();
    }

    @RequestMapping("testDriect")
    public void testDriect(){
        messageConsumer.testDirect();
    }

    @RequestMapping("testTopic")
    public void testTopic(){
        messageConsumer.testTopic();
    }
}
