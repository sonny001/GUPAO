package com.sxd.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloWorldService iHelloWorldService = rpcProxyClient.clientProxy(IHelloWorldService.class, "localhost", 8080);

        String result = iHelloWorldService.hello("SXD");
        System.out.println(result);

        User user = new User();
        user.setAge(18);
        user.setName("sonny");
        iHelloWorldService.saveUser(user);
    }
}
