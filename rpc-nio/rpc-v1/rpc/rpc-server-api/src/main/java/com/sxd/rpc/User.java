package com.sxd.rpc;

import java.io.Serializable;

/**
 * @program rpc-server
 * @description: 用户对象
 * @author: sonny
 * @create: 2020/03/22 18:51
 */
public class User implements Serializable {


    private static final long serialVersionUID = -2218854702029625637L;

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
