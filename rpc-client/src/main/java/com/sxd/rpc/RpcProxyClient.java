package com.sxd.rpc;

import java.lang.reflect.Proxy;

/**
 * @program rpc-server
 * @description: 代理客户端
 * @author: sonny
 * @create: 2020/03/23 19:59
 */
public class RpcProxyClient {

    public <T> T clientProxy(Class<T> interfaceClass, String host, int port) {
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new RemoteInvocationHandler(host, port));
    }
}
