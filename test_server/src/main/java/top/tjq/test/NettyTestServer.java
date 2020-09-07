package top.tjq.test;

import top.tjq.api.HelloService;
import top.tjq.client.ServiceRegistry;
import top.tjq.client.netty.server.NettyServer;
import top.tjq.client.registry.DafaultServiceRegistry;

/**
 * Create by moling_tjq on 2020-09-04
 */
public class NettyTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DafaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }
}
