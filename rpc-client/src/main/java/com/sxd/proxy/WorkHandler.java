package com.sxd.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program rpc-server
 * @description: 工作代理处理方法
 * @author: sonny
 * @create: 2020/03/23 22:15
 */
public class WorkHandler implements InvocationHandler {

    private Object service;

    public WorkHandler(Object service) {
        this.service = service;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result=method.invoke(service, args);
        System.out.println("after invoke");
        return result;
    }
}
