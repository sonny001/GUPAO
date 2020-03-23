package com.sxd.shareLock;

import java.util.concurrent.CyclicBarrier;

/**
 * @program thread-demo
 * @description: Cyclibarrier 测试demo
 * @author: sonny
 * @create: 2020/03/22 14:12
 */
public class CycliBarrierDemo extends Thread {

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
        System.out.println("数据完全导入，开始数据分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CycliBarrierDemo());
        new Thread(new DataImportThead("file1", cyclicBarrier)).start();
        new Thread(new DataImportThead("file2", cyclicBarrier)).start();
        new Thread(new DataImportThead("file3", cyclicBarrier)).start();
    }
}
