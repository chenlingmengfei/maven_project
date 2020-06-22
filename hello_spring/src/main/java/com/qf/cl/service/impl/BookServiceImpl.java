package com.qf.cl.service.impl;

import com.qf.cl.dao.BookMapper;
import com.qf.cl.entity.Book;
import com.qf.cl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectBookList() {
        return bookMapper.selectBookList();
    }

    @Override
    public List<Book> selectBookByName(String bookname) {
        return bookMapper.selectBookByName(bookname);
    }

    @Override
    public Integer addBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public Integer deleteBookById(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public Integer UpdateBookById(Book book) {
        return bookMapper.updateBook(book);
    }
}
