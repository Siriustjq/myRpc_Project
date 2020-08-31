package top.tjq.test;

import top.tjq.api.HelloService;
import top.tjq.client.RpcServer;

/**
 * Create by moling_tjq on 2020-08-24
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}
