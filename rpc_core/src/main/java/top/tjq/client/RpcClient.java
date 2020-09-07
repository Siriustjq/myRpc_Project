package top.tjq.client;

/**
 * Create by moling_tjq on 2020-09-03
 * 利用netty网络框架进行通信，所以见client抽象为接口的形式
 */
public interface RpcClient {
    Object sendRequest(entity.RpcRequest rpcRequest);
}
