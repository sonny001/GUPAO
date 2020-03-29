package com.sxd.rpc.imple;

import com.sxd.rpc.IHelloWorldService;
import com.sxd.rpc.core.RpcService;
import com.sxd.rpc.User;

/**
 * @program rpc-server
 * @description: 实现类
 * @author: sonny
 * @create: 2020/03/22 18:54
 */
@RpcService(value = IHelloWorldService.class,version = "1.0")
public class IHelloWorldServiceImpl implements IHelloWorldService {

    @Override
    public String hello(String content) {
        StringBuilder stringBuilder = new StringBuilder("hello content:");
        stringBuilder.append(content);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public String saveUser(User user) {
        System.out.println("saveUser User:"+user);
        return "success";
    }
}
