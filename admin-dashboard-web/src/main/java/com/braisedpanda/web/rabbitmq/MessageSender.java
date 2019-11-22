package com.braisedpanda.web.rabbitmq;


import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: admin-dashboard
 * @description:
 * @author: chenzhen
 * @create: 2019-11-22 13:45
 **/
@Component
public class MessageSender {



    @Resource
    private RabbitTemplate rabbitTemplate;
    
    /** 
    * @Description: 广播模式 
    * @author: chenzhen
    * @Date: 2019/11/22 0022 
    */ 
    public void testFanout(){
        for (int i=0;i<10;i++){
            String msg = "[Fanout模式]发送第"+i+"条消息";

            rabbitTemplate.convertAndSend("fanoutExchange","1",msg);
        }
    }
    /** 
    * @Description: 完全匹配模式 
    * @author: chenzhen
    * @Date: 2019/11/22 0022 
    */ 
    public void testDirect(){
        for (int i=0;i<10;i++){
            String msg = "[Direct模式]发送第"+i+"条消息";

            rabbitTemplate.convertAndSend("directExchange","333333",msg);
        }
    }
    /** 
    * @Description: 主题模式，可以模糊匹配
    * @author: chenzhen
    * @Date: 2019/11/22 0022 
    */ 
    public void testTopic(){
        for (int i=0;i<10;i++){
            String msg = "[Topic]发送第"+i+"条消息";

            rabbitTemplate.convertAndSend("topicExchange","topic#",msg);
        }
    }

}
