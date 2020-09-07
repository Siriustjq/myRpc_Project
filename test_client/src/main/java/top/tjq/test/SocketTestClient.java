package top.tjq.test;

import top.tjq.api.HelloObject;
import top.tjq.api.HelloService;
import top.tjq.client.RpcClientProxy;
import top.tjq.client.netty.client.SocketClient;

/**
 * Create by moling_tjq on 2020-09-04
 */
public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient("127.0.0.1", 9000);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}
