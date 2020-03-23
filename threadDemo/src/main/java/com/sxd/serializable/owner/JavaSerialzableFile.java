package com.sxd.serializable.owner;

import java.io.*;

/**
 * @program thread-demo
 * @description: 文件序列化
 * @author: sonny
 * @create: 2020/03/22 16:46
 */
public class JavaSerialzableFile implements JavaSerialzable{


    @Override
    public <T> byte[] serial(T obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerial(byte[] bytes, Class<T> clazz) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")));
            return (T)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
