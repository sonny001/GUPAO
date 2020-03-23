package com.sxd.serializable;

import java.io.Serializable;

/**
 * @program thread-demo
 * @description: 用户对象
 * @author: sonny
 * @create: 2020/03/22 16:24
 */
public class User implements Serializable {


    private static final long serialVersionUID = 1932379446929230775L;

    private Integer age;
    private transient String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
