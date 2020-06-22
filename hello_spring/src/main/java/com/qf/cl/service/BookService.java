package com.qf.cl.service;

import com.qf.cl.entity.Book;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
public interface BookService {

    List<Book> selectBookList();

    List<Book> selectBookByName(String bookname);

    Integer addBook(Book book);

    Integer deleteBookById(Integer id);

    Integer UpdateBookById(Book book);

}
