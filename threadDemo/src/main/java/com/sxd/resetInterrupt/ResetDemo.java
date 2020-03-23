package com.sxd.resetInterrupt;

import java.util.concurrent.TimeUnit;

/**
 * @program thread-demo
 * @description: 复位阻塞
 * @author: sonny
 * @create: 2020/03/21 13:13
 */
public class ResetDemo {


    public static void main(String[] args) throws InterruptedException {
//        resetByInterrupted();
        resetByException();


    }

    /**
     * @Author sonny
     * @Description 通过Thread.interrupted 重置线程状态
     * @Date  2020-03-21 13:26
     * @param null
     * @return
     */
    private static void resetByInterrupted() throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before:" + Thread.currentThread().isInterrupted());
                    //线程重置中断
                    Thread.interrupted();
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }

            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);

        //线程中断
        thread.interrupt();
    }

    /**
     * @Author sonny
     * @Description 通过异常的方式重置阻塞的线程状态
     * @Date  2020-03-21 13:26
     * @param null
     * @return
     */
    private static int i = 1;
    private static void resetByException() throws InterruptedException {
        Thread thread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println(i);
                try {
                    //阻塞已经处于阻塞状态的线程，会抛出异常，在抛出异常之前，重置线程状态
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Demo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);

        //将线程状态修改为阻塞。
        thread.interrupt();
    }


}
