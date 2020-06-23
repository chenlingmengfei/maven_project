package com.qf.cl.controller;

import com.github.pagehelper.PageInfo;
import com.qf.cl.entity.Book;
import com.qf.cl.entity.DataInfo;
import com.qf.cl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/22
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{pagenum}")
    //查询所有书籍
    public PageInfo<Book> showBook(@PathVariable Integer pagenum){

        PageInfo<Book> bookPageInfo = bookService.selectPageInfo(pagenum);

        return bookPageInfo;
    }

    @DeleteMapping("/book/{id}")
    //删除书籍
    public DataInfo deleteBook(@PathVariable Integer id){
        Integer integer = bookService.deleteBookById(id);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("delete success");
        }else {
            data.setStatus(0);
            data.setInfo("delete failure");
        }
        return data;
    }

    @PostMapping("/book")
    //添加书籍
    public DataInfo addBook(Book book){
        Integer integer = bookService.addBook(book);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("add success");
        }else {
            data.setStatus(0);
            data.setInfo("add failure");
        }
        return data;
    }


    @GetMapping("/book")
    //查找书籍
    public List<Book> findBook(String bookname){

        List<Book> books = bookService.selectBookByName(bookname);

        return books;
    }

    @PutMapping("/book")
    //修改书籍
    public DataInfo updateBook(Book book){
        Integer integer = bookService.UpdateBookById(book);
        DataInfo data = new DataInfo();
        if(integer == 1){
            data.setStatus(1);
            data.setInfo("update success");
        }else {
            data.setStatus(0);
            data.setInfo("update failure");
        }
        return data;
    }

}