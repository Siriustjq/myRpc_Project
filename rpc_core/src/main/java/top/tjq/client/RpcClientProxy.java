package top.tjq.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by moling_tjq on 2020-08-23
 * 利用代理类去生成目标的调用
 */
public class RpcClientProxy implements InvocationHandler{
    private String host;
    private int port;

    public RpcClientProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     * InvocationHandler接口需要实现invoke()方法，来指明代理对象的方法被调用时的动作。
     * 在这个简单的rpc框架中，当代理对象的方法被调用时，应该向服务提供方发出一个rpcRequest对象，获取真正的服务本体
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        entity.RpcRequest rpcRequest = entity.RpcRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameters(args)
                .paramType(method.getParameterTypes())
                .build();
        RpcClient rpcClient = new RpcClient();
        return ((entity.RpcRespone) rpcClient.sendRequest(rpcRequest, host, port)).getData();
    }
}
