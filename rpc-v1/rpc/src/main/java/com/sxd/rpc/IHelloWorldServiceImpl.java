package com.sxd.rpc;

/**
 * @program rpc-server
 * @description:
 * @author: sonny
 * @create: 2020/03/23 20:22
 */
public class IHelloWorldServiceImpl implements IHelloWorldService {


    @Override
    public String hello(String content) {
        System.out.println("IHelloWorldService.hell content:"+content);
        return "Hello World " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("IHelloWorldService.saveUser user:" + user);
        return "success";
    }
}
