package com.sxd.shareLock;

import java.util.concurrent.CountDownLatch;

/**
 * @program thread-demo
 * @description: CountDownLatchDemo，多线程校验，一起返回结果
 * @author: sonny
 * @create: 2020/03/22 13:05
 */
public class CountDownLatchDemo extends  Thread {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchDemo().start();

        }
        countDownLatch.countDown();
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TheadName:"+Thread.currentThread().getName());
    }
}
