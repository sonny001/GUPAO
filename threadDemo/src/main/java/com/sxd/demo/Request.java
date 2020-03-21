package com.sxd.demo;

/**
 * @program thread-demo
 * @description: 测试对象
 * @author: sonny
 * @create: 2020/03/20 23:43
 */
public class Request {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
