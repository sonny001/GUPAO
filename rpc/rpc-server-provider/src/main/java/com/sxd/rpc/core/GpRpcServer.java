package com.sxd.rpc.core;

import com.sxd.rpc.imple.ProcesserHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program rpc-server
 * @description: 通过spring管理rpc服务注入
 * @author: sonny
 * @create: 2020/03/27 21:54
 */
public class GpRpcServer implements ApplicationContextAware, InitializingBean {


    private int port;
    private Map<String, Object> handlerMap = new HashMap<>();

    public GpRpcServer(int port) {
        this.port = port;
    }


    ExecutorService executorService = Executors.newCachedThreadPool();


    @Override
    public void afterPropertiesSet() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcesserHandler(socket, handlerMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       Map<String,Object> serviceBeanMap= applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()) {
            for (Object serviceBean : serviceBeanMap.values()) {
                RpcService rpcService=serviceBean.getClass().getAnnotation(RpcService.class);
                String serviceName = rpcService.value().getName();
                String version = rpcService.version();
                if (!StringUtils.isEmpty(serviceBean)) {
                    serviceName += "-" + version;
                }
                System.out.println(serviceName);
                handlerMap.put(serviceName, serviceBean);
            }
        }
    }


}
