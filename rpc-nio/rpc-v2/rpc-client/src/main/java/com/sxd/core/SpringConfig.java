package com.sxd.core;

import com.sxd.rpc.RpcProxyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program rpc-server
 * @description: spring配置类
 * @author: sonny
 * @create: 2020/03/27 22:48
 */
@Configuration
public class SpringConfig {

    @Bean(name = "rpcProxyClient")
    public RpcProxyClient rpcProxyClient() {
        return new RpcProxyClient();
    }
}
