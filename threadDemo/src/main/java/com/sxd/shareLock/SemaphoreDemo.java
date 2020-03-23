package com.sxd.shareLock;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program thread-demo
 * @description: 资源抢占，实现停车场停车
 * @author: sonny
 * @create: 2020/03/22 13:53
 */
public class SemaphoreDemo {



    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
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
                semaphore.acquire();
                System.out.println("第"+num+"抢到车位！");
                int param = new Random().nextInt(10);
                System.out.println("第"+num+" 车，停"+param+"秒");
                TimeUnit.SECONDS.sleep(param);
                System.out.println("第"  +num+" 车开走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <= 10; i++) {
            Car car = new Car(i,semaphore);
            car.start();
        }
    }


}
