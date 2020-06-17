package com.qf.cl.mapper;

import com.qf.cl.entity.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/16
 */
public interface UserMapper {

    public List<User> selectUser();

}
