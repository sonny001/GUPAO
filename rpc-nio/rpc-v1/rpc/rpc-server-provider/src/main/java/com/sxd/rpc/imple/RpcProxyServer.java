package com.sxd.rpc.imple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program rpc-server
 * @description:
 * @author: sonny
 * @create: 2020/03/22 19:48
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();



    public void publisher(Object service, int port) {
        ServerSocket serverSocket=null;
        try {
            serverSocket= new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcesserHandler(socket,service));
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
}
