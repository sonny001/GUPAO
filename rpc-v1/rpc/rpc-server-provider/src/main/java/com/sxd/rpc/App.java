package com.sxd.rpc;

import com.sxd.rpc.imple.IHelloWorldServiceImpl;
import com.sxd.rpc.imple.RpcProxyServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IHelloWorldService iHelloWorldService = new IHelloWorldServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();

        rpcProxyServer.publisher(iHelloWorldService,8080);
    }
}
