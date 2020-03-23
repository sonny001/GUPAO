package com.sxd.serializable.owner;

public interface JavaSerialzable {


    <T> byte[] serial(T obj);

    <T> T deSerial(byte[] bytes,Class<T> clazz);
}
