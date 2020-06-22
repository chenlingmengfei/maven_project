package com.qf.cl.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/20
 */
//@Aspect
//@Component
public class MybeforeAdvice {


    @Pointcut("execution(* com.qf.cl.service.UserService.selectUser(..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public void before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法前");
        proceedingJoinPoint.proceed();
        //System.out.println(proceedingJoinPoint.getSignature().getDeclaringTypeName());
        System.out.println("方法后");
    }


}
