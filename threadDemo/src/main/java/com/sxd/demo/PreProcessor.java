package com.sxd.demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program thread-demo
 * @description:
 * @author: sonny
 * @create: 2020/03/20 23:44
 */
public class PreProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    private IRequestProcessor nextProcessor;

    private volatile Boolean isFinish = false;

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
        while (!isFinish) {
            try {
                Request request = requests.take();
                System.out.println("PreProcessor:" + request);

                if (nextProcessor != null) {
                    nextProcessor.processer(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void processer(Request request) {
        requests.add(request);
    }

    public void shutDown() {
        isFinish = true;
    }


    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public PreProcessor() {
    }


    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public PreProcessor(IRequestProcessor iRequestProcessor) {
        this.nextProcessor = iRequestProcessor;
    }
}
