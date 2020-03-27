package com.sxd.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @program rpc-server
 * @description:
 * @author: sonny
 * @create: 2020/03/23 22:17
 */
public class Demo {
    public static void main(String[] args) {

        People people = new Teacher();
        InvocationHandler invocationHandler = new WorkHandler(people);

        People peopleProxy=(People) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), people.getClass().getInterfaces(), invocationHandler);
        peopleProxy.work();
    }
}
