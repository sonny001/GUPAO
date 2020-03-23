package com.sxd.rpc;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @program rpc-server
 * @description: 通信对象
 * @author: sonny
 * @create: 2020/03/22 19:34
 */
public class RpcRequest implements Serializable {


    private static final long serialVersionUID = 335804010028489938L;
    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
