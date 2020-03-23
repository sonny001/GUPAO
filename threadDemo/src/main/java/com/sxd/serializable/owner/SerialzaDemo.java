package com.sxd.serializable.owner;

import com.sxd.serializable.User;

import javax.sound.midi.SoundbankResource;

/**
 * @program thread-demo
 * @description:
 * @author: sonny
 * @create: 2020/03/22 16:54
 */
public class SerialzaDemo {

    public static void main(String[] args) {

        User user = new User();
        user.setName("张三");
        user.setAge(18);

        JavaSerialzable javaSerialzable = new JavaSerialzableFile();
        javaSerialzable.serial(user);

        User resultUser=javaSerialzable.deSerial(null,User.class);
        System.out.println(resultUser);
    }
}
