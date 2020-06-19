package com.qf.cl.factory;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/19
 */
public class MyFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql:///nz_2001", "root", "123456");
        return root;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
