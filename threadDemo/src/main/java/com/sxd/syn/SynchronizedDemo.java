package com.sxd.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program thread-demo
 * @description: 同步锁
 * @author: sonny
 * @create: 2020/03/21 14:24
 */
public class SynchronizedDemo {

    private Object object;

    public SynchronizedDemo(Object object) {
        this.object = object;
    }

    public  void test1(int threadNum){
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                System.out.println("threadNum:"+threadNum +" i:"+i);
            }
        }
    }

    public synchronized static void test2(int threadNum){

        for (int i = 0; i < 5; i++) {
            System.out.println("threadNum:"+threadNum +" i:"+i);
        }
    }

    public static void main(String[] args) {
//        new Thread(() -> SynchronizedDemo.test2(1)).start();
//        new Thread(() ->SynchronizedDemo.test2(2)).start();


//        SynchronizedDemo demo = new SynchronizedDemo();
//        new Thread(() -> demo.test1(1)).start();
//        new Thread(() ->demo.test1(2)).start();

        Object lock = new Object();
        SynchronizedDemo demo1 = new SynchronizedDemo(lock);
        SynchronizedDemo demo2 = new SynchronizedDemo(lock);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            demo1.test1(1);
        });
        executorService.execute(() -> {
            demo2.test1(2);
        });
    }
}
