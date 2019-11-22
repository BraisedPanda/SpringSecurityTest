package com.braisedpanda.web.controller;

import com.braisedpanda.commons.model.User;

import com.braisedpanda.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: admin-dashboard
 * @description:

 * @create: 2019-11-20 10:31
 **/
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
    * @Description: 跳转到登录界面

    * @Date: 2019/11/20 0020
    */
    @RequestMapping("/tologin")
    public ModelAndView tologin(){
        return new ModelAndView("login");
    }

    /**
    * @Description: 用户登录

    * @Date: 2019/11/20 0020
    */
    @RequestMapping("/login")
    public ModelAndView login(){

        return new  ModelAndView("index");
    }

    /**
     * @Description: 退出登录

     * @Date: 2019/11/20 0020
     */
    @RequestMapping("/logout")
    public ModelAndView logout(){

        return new  ModelAndView("login");
    }

    @RequestMapping("/regist")
    public ModelAndView regist(User user){
        userService.insertUser(user);
        return new  ModelAndView("index");
    }

    @RequestMapping("/toregist")
    public ModelAndView toregist(){

        return new  ModelAndView("regist");
    }
    
}
