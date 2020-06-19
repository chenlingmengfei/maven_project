package com.qf.cl.service.impl;

import com.qf.cl.dao.UserDao;
import com.qf.cl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void selectUser() {
        System.out.println("find user ..... UserService");
        userDao.selectUser();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
