package top.tjq.test;

import top.tjq.api.HelloService;
import top.tjq.client.RpcServer;
import top.tjq.client.ServiceRegistry;
import top.tjq.client.registry.DafaultServiceRegistry;

/**
 * Create by moling_tjq on 2020-08-24
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
//        RpcServer rpcServer = new RpcServer();
//        rpcServer.register(helloService, 9000);
        ServiceRegistry serviceRegistry = new DafaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }
}
