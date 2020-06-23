package com.qf.cl.controller;

import com.qf.cl.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/23
 */
@Controller
@RequestMapping("/save")
@CrossOrigin(allowCredentials = "true") //加此注解允许跨域访问
public class SaveDataController {


    @RequestMapping("/saveSession")
    public String saveSession(HttpSession session){

        session.setAttribute("name","zhangfei");

        return "index";
    }


    @ResponseBody
    @RequestMapping("/getBook")
    public Book getBook(){
       return new Book(1,"zhangsang","tanhaoqian",
               "zhongguoyoudian","yizhilei",new Date(),100.127);
    }

    @RequestMapping("/getnull")
    public String getNull(String num){
        num.toString();
        return "index";
    }

}
