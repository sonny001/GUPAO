package com.sxd.io.nio.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program io-demo
 * @description: buffer 调用不通方法参数的值
 * @author: sonny
 * @create: 2020/03/28 21:00
 */
public class BufferParamDemo {

    public static void main(String[] args) {
        String filePath = "/Users/sonny/IdeaProjects/github/咕泡/Gupao/io-demo/src/main/java/com/sxd/io/nio/buffer/data.txt";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            FileChannel fileChannel = inputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            outPrint("初始化", byteBuffer);

            fileChannel.read(byteBuffer);
            outPrint("read()", byteBuffer);

            byteBuffer.flip();
            outPrint("flip()", byteBuffer);

            while (byteBuffer.remaining()>0) {
                byteBuffer.get();
            }

            byteBuffer.clear();
            outPrint("clear()", byteBuffer);

            fileChannel.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void  outPrint(String step,ByteBuffer byteBuffer) {
        System.out.println(step+": ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("capacity");
        stringBuilder.append(byteBuffer.capacity());
        stringBuilder.append(",");

        stringBuilder.append("limit");
        stringBuilder.append(byteBuffer.limit());
        stringBuilder.append(",");

        stringBuilder.append("position");
        stringBuilder.append(byteBuffer.position());
        System.out.println(stringBuilder.toString());

    }
}
