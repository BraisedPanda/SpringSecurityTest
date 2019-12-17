package com.braisedpanda.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: admin-dashboard
 * @description:

 * @create: 2019-11-21 13:52
 **/
@RestController
public class JumpController {

    @RequestMapping("/categories")
    public ModelAndView categories(){

        return new  ModelAndView("page/categories");
    }

    @RequestMapping("/productPage")
    public ModelAndView productPage(){

        return new  ModelAndView("page/product-page");
    }

    @RequestMapping("/checkout")
    public ModelAndView checkout(){

        return new  ModelAndView("page/check-out");
    }

    @RequestMapping("/contact")
    public ModelAndView contact(){

        return new  ModelAndView("page/contact");
    }

    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart(){

        return new  ModelAndView("page/shopping-cart");
    }


    @RequestMapping("/index")
    public ModelAndView index(){

        return new  ModelAndView("demo1");
    }
}
