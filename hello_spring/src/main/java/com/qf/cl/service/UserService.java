package com.qf.cl.service;

import com.qf.cl.entity.User;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
public interface UserService {

    List<User> selectUser();
}
