package com.qf.cl.dao;

import com.qf.cl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
@Mapper
public interface UserMapper {

    //List<User> selectUser();

    @Select("select * from t_users")
    List<User> selectList();

}
