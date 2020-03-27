package com.sxd.rpc.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program rpc-server
 * @description: spring配置类
 * @author: sonny
 * @create: 2020/03/27 22:15
 */
@Configuration
@ComponentScan("com.sxd.rpc.imple")
public class SpringConfig {

    @Bean(name = "gpRpcServer")
    public GpRpcServer gpRpcServer(){
        return new GpRpcServer(8080);
    }
}
