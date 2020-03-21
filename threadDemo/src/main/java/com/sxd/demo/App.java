package com.sxd.demo;

import com.sun.org.apache.regexp.internal.RE;

import java.util.jar.Attributes;

/**
 * @program thread-demo
 * @description:
 * @author: sonny
 * @create: 2020/03/20 23:53
 */
public class App {

    private static IRequestProcessor iRequestProcessor;

    public  void buildData(){
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();

        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        saveProcessor.start();

        iRequestProcessor = new PreProcessor(saveProcessor);
        ((PreProcessor)iRequestProcessor).start();


    }

    public static void main(String[] args) {

        Request request = new Request();
        request.setName("张三");

        App app = new App();
        app.buildData();

        iRequestProcessor.processer(request);


    }
}
