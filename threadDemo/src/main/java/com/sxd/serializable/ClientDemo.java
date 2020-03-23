package com.sxd.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @program thread-demo
 * @description: 客户端
 * @author: sonny
 * @create: 2020/03/22 16:29
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        User user = new User();
        user.setAge(18);
        user.setName("张三");

        objectOutputStream.writeObject(user);
        socket.close();
    }
}
