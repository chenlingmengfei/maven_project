package com.qf.cl.controller;

import com.qf.cl.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/addBook")
    public String addBook(Book book){
        System.out.println(book);
        return "index";
    }

    @RequestMapping("/bookId/{id}")
    public String bookId(@PathVariable Integer id){
        System.out.println(id);
        return "index";
    }
}




