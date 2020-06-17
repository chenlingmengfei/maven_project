package com.qf.cl.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: MybatisUtils
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/16
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> sqlSessionList = new ThreadLocal<>();

    static{
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //打开sqlsession
    private static SqlSession openSession(){
        SqlSession session = sqlSessionList.get();
        if(session == null){
            session = sqlSessionFactory.openSession();
            sqlSessionList.set(session);
        }
        return session;
    }

    //释放连接（释放当前线程中的SqlSession）
    private static void closeSession(){
        SqlSession session = sqlSessionList.get();
        session.close();
        sqlSessionList.remove();
    }

    //提交事务（提交当前线程中的SqlSession所管理的事务）
    public static void commit(){
        SqlSession session = openSession();
        session.commit();
        closeSession();
    }

    //回滚事务（回滚当前线程中的SqlSession所管理的事务）
    public static void rollback(){
        SqlSession session = openSession();
        session.rollback();
        closeSession();
    }

    //获得接口实现类对象
    public static <T extends Object> T getMapper(Class<T> clazz){
        SqlSession session = openSession();
        return session.getMapper(clazz);
    }

}
