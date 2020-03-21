package com.sxd.interrupter;

import java.util.concurrent.TimeUnit;

/**
 * @program thread-demo
 * @description: 阻断测试
 * @author: sonny
 * @create: 2020/03/21 12:56
 */
public class InterrupterDemo {

    private static int i=1;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{

            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println(i);
            }
        },"Demo");
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();
    }
}
