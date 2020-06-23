package com.qf.cl.web.servlet;

import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/21
 */
//@WebServlet("*.bean")
public class BaseServlet extends HttpServlet {

    ApplicationContext applicationContext = null;

    @Override
    public void init() throws ServletException {
        //加载spring容器
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    private Gson gson = new Gson();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String servletpath = req.getServletPath();

        String beanName = servletpath.substring(servletpath.lastIndexOf('/')+1,servletpath.indexOf(".bean"));

        //获取容器中的bean即servlet
        Object bean = applicationContext.getBean(beanName);

        //获取操作方法
        String methodName = req.getParameter("method");

        //通过反射获取方法对象
        Method method = getMethodToMethodName(bean,methodName);

        if(method != null || null != bean){
            executeOper(bean,method,req,resp);
        }else{
            resp.getWriter().write("方法不存在");
        }


    }

    //给方法参数赋值
    private void executeOper(Object o,Method method, HttpServletRequest req, HttpServletResponse resp) {
        //获取方法参数个数
        int parameterCount = method.getParameterCount();

        //将参数值装入数组中
        Object[] parameterArray = new Object[parameterCount];

        //给数组赋值
        paramOper(method,parameterArray,req,resp);

        Object returnString = null;

        try {

            method.setAccessible(true);

            returnString = method.invoke(o,parameterArray);

            if(null != returnString){
                String[] split = returnString.toString().split(":");

                //跳转还是重定向
                String headmsg = split[0];

                //执行的url
                String url = split[1];

                if("forward".equals(headmsg)){
                    req.getRequestDispatcher(url).forward(req,resp);
                }else if("redirect".equals(headmsg)){
                    resp.sendRedirect(url);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void paramOper(Method method, Object[] parameterArray, HttpServletRequest req, HttpServletResponse resp) {

        //获取方法所有的参数
        Parameter[] parameters = method.getParameters();

        //获取请求的所有参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        //获取方法形参信息
        LocalVariableTableParameterNameDiscoverer localVariable = new LocalVariableTableParameterNameDiscoverer();

        //获取所有形参名
        String[] parameterNames = localVariable.getParameterNames(method);

        //遍历循环添加到参数数组中
        for (int i = 0; i < parameters.length; i++) {

            //获取数据类型名
            String simpleName = parameters[i].getType().getSimpleName();

            if("HttpServletRequest".equals(simpleName)){
                parameterArray[i] = req;
            }else if("HttpServletResponse".equals(simpleName)){
                parameterArray[i] = resp;
            }else if("Integer".equals(simpleName)){
                String name = parameterNames[i];
                String value = req.getParameter(name);
                parameterArray[i] = Integer.parseInt(value);
            } else if("String".equals(simpleName)){
                String name = parameterNames[i];
                String value = req.getParameter(name);
                parameterArray[i] = value;
            }else if("BigDecimal".equals(simpleName)){
                String name = parameterNames[i];
                String value = req.getParameter(name);
                parameterArray[i] = new BigDecimal(value);
            }else{
                try {
                    //给对象赋值
                    Object instance = parameters[i].getType().newInstance();

                    Map<String,Object> objectMap = convertStringToObject(parameterMap);

                    //把map的数据赋值给对象
                    BeanUtils.populate(instance,objectMap);
                    //把对象放到数组中
                    parameterArray[i] = instance;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //把Map<String, String[]>转成Map<String,Object>
    private Map<String,Object> convertStringToObject(Map<String, String[]> parameterMap) {
        Map<String,Object> map = converMap(parameterMap);

        //日期转换的操作
        converDate(map);

        return map;
    }

    private void converDate(Map<String, Object> map) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            String value = (String) entry.getValue(); //1990-10-10  1990/10/10
            if(value.contains("-") || value.contains("/")){
                try {
                    Date date = format.parse(value);
                    entry.setValue(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Map<String,Object> converMap(Map<String, String[]> parameterMap) {
        Map<String,Object> objectMap = new HashMap<>();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            objectMap.put(entry.getKey(),entry.getValue()[0]);
        }
        return objectMap;
    }

    //获取方法对象
    private Method getMethodToMethodName(Object o,String methodName) {

        //获取所有的方法对象
        Method[] methods = o.getClass().getDeclaredMethods();

        for(Method method : methods){

            //获取指定的方法对象
            if(method.getName().equals(methodName)){
                return method;
            }
        }
        return null;
    }

    public void sendJson(Object object, HttpServletResponse response){

        String json = gson.toJson(object);

        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
