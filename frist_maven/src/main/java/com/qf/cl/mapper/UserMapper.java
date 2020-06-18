package com.qf.cl.mapper;

import com.qf.cl.entity.User;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM t_users")
    List<User> selectUser(Integer id);


    @Select("SELECT * FROM t_users\n" +
            "            where  name = #{name} and password = #{pwd}")
    User selectUserByIdAndPassword(@Param("name") String name, @Param("pwd")String pwd);

    @Insert("insert into t_users values(null,#{name},#{password},#{sex},#{birthday},#{registTime})")
    int insertUser(User user);

    @Update("update t_users set name=#{name},password=#{password},sex=#{sex} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from t_users where id=#{id}")
    int deleteUser(Integer id);

}
