package com.sxd.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program io-demo
 * @description: bio服务端
 * @author: sonny
 * @create: 2020/03/28 13:58
 */
public class BioServer {

    private ServerSocket serverSocket = null;

    public BioServer(int port) {
        try {
            this.serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        while (true) {
            try {
               Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();

                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                if (len > 0) {
                    String result = new String(bytes, 0, len);
                    System.out.println(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        BioServer server = new BioServer(8080);
        server.listen();

    }


}
