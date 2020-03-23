package com.sxd.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program thread-demo
 * @description: 通知
 * @author: sonny
 * @create: 2020/03/22 12:23
 */
public class ConditionWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
      try{
          lock.lock();
          System.out.println("start ConditionWait");
          try{
              condition.await();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("end ConditionWait");

      } finally {
          lock.unlock();
      }
    }
}
