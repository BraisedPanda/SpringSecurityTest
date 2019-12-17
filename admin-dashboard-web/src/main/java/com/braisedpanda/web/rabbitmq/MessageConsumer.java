//package com.braisedpanda.web.rabbitmq;
//
//import com.alibaba.fastjson.JSONObject;
//import com.braisedpanda.commons.model.User;
//import com.braisedpanda.web.mapper.UserMapper;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @program: admin-dashboard
// * @description:
// * @author: chenzhen
// * @create: 2019-11-22 13:43
// **/
//@Component
//public class MessageConsumer {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**fanout测试**/
//    @RabbitListener(bindings = @QueueBinding(
//            key = "11111",
//            value = @Queue("fanoutQueue1"),
//            exchange = @Exchange(value = "fanoutExchange",type = "fanout")
//
//    ))
//    public void receive1(String msg){
//        System.out.println("Fanout接收消息1："+msg);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            key = "2222",
//            value = @Queue("fanoutQueue2"),
//            exchange = @Exchange(value = "fanoutExchange",type = "fanout")
//
//    ))
//    public void receive2(String msg){
//        System.out.println("Fanout接收消息2："+msg);
//    }
//
//
//    /**direct测试**/
//    @RabbitListener(bindings = @QueueBinding(
//            key = "insertUser",
//            value = @Queue("directQueue1"),
//            exchange = @Exchange(value = "directExchange",type = "direct")
//
//    ))
//    public void receive3(String msg){
//        User user = JSONObject.parseObject(msg,User.class);
//        userMapper.insert(user);
//
//    }
//
//
//
//
//    /**topic测试**/
//    @RabbitListener(bindings = @QueueBinding(
//            key = "topic555555",
//            value = @Queue("topictQueue1"),
//            exchange = @Exchange(value = "topicExchange",type = "top ic")
//
//    ))
//    public void receive5(String msg){
//        System.out.println("topic接收消息1："+msg);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            key = "topic66666",
//            value = @Queue("topicQueue2"),
//            exchange = @Exchange(value = "topicExchange",type = "topic")
//
//    ))
//    public void receive6(String msg){
//        System.out.println("topic接收消息2："+msg);
//    }
//
//
//}
