package com.qf.cl.execption;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/23
 */
//错误解析器
public class MyExecptionHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();

        ModelAndView mv = new ModelAndView();

        if(e instanceof NullPointerException){
            mv.setViewName("redirect:/error/error1.html");
        }else {
            mv.setViewName("redirect:/error/error.html");
        }

        return mv;
    }
}
