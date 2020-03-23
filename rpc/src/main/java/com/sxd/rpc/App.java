package com.sxd.rpc;

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
