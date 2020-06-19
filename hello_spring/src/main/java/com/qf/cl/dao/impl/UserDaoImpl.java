package com.qf.cl.dao.impl;

import com.qf.cl.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void selectUser() {
        System.out.println("find user .....UserDao");
    }
}
