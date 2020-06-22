package com.qf.cl.service.impl;

import com.qf.cl.dao.UserMapper;
import com.qf.cl.entity.User;
import com.qf.cl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
public class UserServiceImpl implements UserService {


    private UserMapper userDao;


    @Override
    public List<User> selectUser() {
        //System.out.println("find user ..... UserService");
        return userDao.selectList();
    }

    public UserMapper getUserDao() {
        return userDao;
    }

    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }
}
