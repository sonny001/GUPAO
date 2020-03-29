package com.sxd.io.nio;

import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @program io-demo
 * @description:
 * @author: sonny
 * @create: 2020/03/28 15:10
 */
public class NioServerDemo {

    private int port;

    private Selector selector;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public NioServerDemo(int port) {
        this.port = port;


        try {
            //开门
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //准备就绪
            selector = Selector.open();
            //开始营业
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        try {

            while (true) {
                //开始叫号
                selector.select();
                //拿到所有的号，开始轮训
                //每次只能叫一个号，因此叫做同步
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey selectionKey = keys.next();
                    keys.remove();
                    processer(selectionKey);

                }
            }

        } catch (Exception e) {

        }
    }

    /**
     * @param null
     * @return
     * @Author sonny
     * @Description 针对每一种状态做出不同的反映
     * @Date 2020-03-28 15:25
     */
    private void processer(SelectionKey selectionKey) {

        try {
            if (selectionKey.isAcceptable()) {
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();

                //此处为非阻塞的实现，不管有没有数据都要返回一个是否准备好的状态
                SocketChannel socketChannel = channel.accept();
                //设置为非阻塞状态
                socketChannel.configureBlocking(false);
                //数据准备就绪的时候，将状态修改为可读
                selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
            } else if (selectionKey.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                int len = socketChannel.read(byteBuffer);
                if (len > 0) {
                    byteBuffer.flip();
                    String content = new String(byteBuffer.array(),0,len);
                    selectionKey = socketChannel.register(selector,SelectionKey.OP_WRITE);
                    //selectionKey 携带一个附件，一会写出去
                    selectionKey.attach(content);
                    System.out.println("content "+content);

                }



            } else if (selectionKey.isWritable()) {
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                String content=(String) selectionKey.attachment();

                socketChannel.write(ByteBuffer.wrap(("输入内容：" + content).getBytes()));
                socketChannel.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new NioServerDemo(8080).listen();
    }

}
