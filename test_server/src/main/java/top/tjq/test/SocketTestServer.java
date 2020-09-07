package top.tjq.test;

import top.tjq.api.HelloService;
import top.tjq.client.ServiceRegistry;
import top.tjq.client.netty.server.SocketServer;
import top.tjq.client.registry.DafaultServiceRegistry;

/**
 * Create by moling_tjq on 2020-09-04
 */
public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DafaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.start(9000);
    }
}
