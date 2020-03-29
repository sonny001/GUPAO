package com.sxd.rpc;

import com.sxd.core.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program rpc-server
 * @description: 客户端
 * @author: sonny
 * @create: 2020/03/27 22:23
 */
public class ClientApp {

    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient=context.getBean(RpcProxyClient.class);

        IHelloWorldService iHelloWorldService = rpcProxyClient.clientProxy(IHelloWorldService.class, "localhost", 8080);

        String result = iHelloWorldService.hello("SXD");
        System.out.println(result);

        User user = new User();
        user.setAge(18);
        user.setName("sonny");
        iHelloWorldService.saveUser(user);
    }
}
