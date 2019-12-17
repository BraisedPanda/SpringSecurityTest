//package com.braisedpanda.web.controller;
//
//import com.braisedpanda.commons.model.User;
//import com.braisedpanda.web.rabbitmq.MessageSender;
//import com.braisedpanda.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @program: admin-dashboard
// * @description:
// * @author: chenzhen
// * @create: 2019-11-22 14:36
// **/
//@RestController
//public class RabbitMQController {
//    @Autowired
//    MessageSender messageConsumer;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("testRabbitMq")
//    public void testRabbitMQ(){
//        messageConsumer.testFanout();
//    }
//
//    @RequestMapping("testDriect")
//    public void testDriect(){
//        messageConsumer.testDirect();
//    }
//
//    @RequestMapping("testTopic")
//    public void testTopic(){
//        messageConsumer.testTopic();
//    }
//
//    @RequestMapping("/testRedis")
//    public void testRedis(){
//       User user =  userService.getUserByUsername("zhangsan");
//        redisTemplate.opsForValue().set("user",user);
//    }
//
//    @RequestMapping("/testRedis2")
//    public void testRedis2(){
//        User user =  (User)redisTemplate.opsForValue().get("user");
//        System.out.println(user);
//    }
//}
