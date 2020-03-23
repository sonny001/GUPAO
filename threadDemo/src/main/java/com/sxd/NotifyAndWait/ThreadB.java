package com.sxd.NotifyAndWait;

/**
 * @program thread-demo
 * @description: 线程a
 * @author: sonny
 * @create: 2020/03/21 20:28
 */
public class ThreadB extends Thread {

    private Object lock;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public ThreadB(Object lock) {
        this.lock = lock;
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
        synchronized (lock) {
            System.out.println("ThreadB before");
            //唤醒线程A，进入同步队列
            lock.notify();
            System.out.println("ThreadB after");
        }
    }
}
