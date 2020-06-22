package com.qf.cl.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/20
 */
public class MyAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName()+"..........."+o.getClass());
    }
}
