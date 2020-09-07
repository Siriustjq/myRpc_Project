package top.tjq.test;

import top.tjq.api.HelloObject;
import top.tjq.api.HelloService;
import top.tjq.client.RpcClient;
import top.tjq.client.RpcClientProxy;
import top.tjq.client.netty.client.NettyClient;

/**
 * Create by moling_tjq on 2020-09-04
 * 测试用Netty消费端
 */
public class NettyTestClient {
    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message!");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}
