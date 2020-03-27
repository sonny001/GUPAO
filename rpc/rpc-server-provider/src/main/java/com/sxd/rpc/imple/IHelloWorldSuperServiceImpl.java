package com.sxd.rpc.imple;

import com.sxd.rpc.IHelloWorldService;
import com.sxd.rpc.User;
import com.sxd.rpc.core.RpcService;

/**
 * @program rpc-server
 * @description: 实现类
 * @author: sonny
 * @create: 2020/03/22 18:54
 */
@RpcService(value = IHelloWorldService.class,version = "2.0")
public class IHelloWorldSuperServiceImpl implements IHelloWorldService {

    @Override
    public String hello(String content) {
        StringBuilder stringBuilder = new StringBuilder("【2.0】hello content:");
        stringBuilder.append(content);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【2.0】saveUser User:"+user);
        return "success";
    }
}
