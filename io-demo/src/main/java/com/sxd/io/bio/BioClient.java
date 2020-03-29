package com.sxd.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @program io-demo
 * @description: bio客户端
 * @author: sonny
 * @create: 2020/03/28 14:05
 */
public class BioClient {


    public static void main(String[] args) {
        Socket socket=null;
        try {
            socket = new Socket("localhost", 8080);

            String param = UUID.randomUUID().toString();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(param.getBytes());
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
