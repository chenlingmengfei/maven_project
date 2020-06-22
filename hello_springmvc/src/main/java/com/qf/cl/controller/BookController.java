package com.qf.cl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/22
 */
@Controller
@RequestMapping("/bookController")
public class BookController {

    @RequestMapping("/findBook")
    public String findBook(Integer id){
        System.out.println(id);
        return "index";
    }
}




