package com.sxd.NotifyAndWait;

/**
 * @program thread-demo
 * @description: NotifyAndWait 测试demo
 * @author: sonny
 * @create: 2020/03/21 20:27
 */
public class NotifyAndWaitDemo {
    public static void main(String[] args) {
        Object lock = new Object();

        //ThreadA 和 ThreadB 同步锁对象必须是同一个
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }
}
