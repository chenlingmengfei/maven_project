package com.qf.cl.mapper;

import com.qf.cl.entity.User;
import org.apache.ibatis.annotations.Param;

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

    List<User> selectUser();


    User selectUserByIdAndPassword(@Param("name") String name, @Param("pwd")String pwd);

    int insertUser(User user);

}
