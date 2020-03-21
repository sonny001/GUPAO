package com.sxd.threadStatus;

import java.util.concurrent.TimeUnit;

/**
 * @program thread-demo
 * @description: 线程状态测试
 * @author: sonny
 * @create: 2020/03/21 12:30
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Time_Thread").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "Wait_Thread").start();

        new Thread(new BlockDemo(),"Bloack_1").start();
        new Thread(new BlockDemo(),"Bloack_2").start();

    }

    static class BlockDemo extends Thread{

        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
