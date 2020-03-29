package com.sxd.io.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program io-demo
 * @description: buffer  测试
 * @author: sonny
 * @create: 2020/03/28 20:44
 */
public class NioBufferDemo {

    public static void main(String[] args) {
        String filePath = "/Users/sonny/IdeaProjects/github/咕泡/Gupao/io-demo/src/main/java/com/sxd/io/nio/buffer/data.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int channelRead = fileChannel.read(byteBuffer);
            if (channelRead != -1) {

                //是缓冲区准备好读取
                byteBuffer.flip();
                byteBuffer.position(2).mark();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get());
                    byteBuffer.reset();
                }
                byteBuffer.clear();
                channelRead = fileChannel.read(byteBuffer);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
