package com.sxd.proxy;

import java.security.acl.Permission;

/**
 * @program rpc-server
 * @description: 老师
 * @author: sonny
 * @create: 2020/03/23 22:14
 */
public class Teacher implements People {

    @Override
    public void work() {
        System.out.println("老师工作，教课育人");
    }
}
