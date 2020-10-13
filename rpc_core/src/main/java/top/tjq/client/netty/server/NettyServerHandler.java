package top.tjq.client.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.tjq.client.RequestHandler;
import top.tjq.client.ServiceRegistry;
import top.tjq.client.registry.DafaultServiceRegistry;

/**
 * Create by moling_tjq on 2020-09-04
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<entity.RpcRequest> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerHandler.class);
    private static RequestHandler requestHandler;
    private static ServiceRegistry serviceRegistry;

    static {
        requestHandler = new RequestHandler();
        serviceRegistry = new DafaultServiceRegistry();
    }
    //当有读取事件触发时（即服务端返回给客户端信息时），触发该方法
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, entity.RpcRequest msg) throws Exception {
        try {
            LOGGER.info("服务器接收到请求: {}", msg);
            String interfaceName = msg.getInterfaceName();
            Object service = serviceRegistry.getService(interfaceName);
            Object result = requestHandler.handle(msg, service);
            ChannelFuture future = ctx.writeAndFlush(entity.RpcRespone.success(result));
            future.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
    //异常捕获
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("处理过程调用时有错误发生:");
        cause.printStackTrace();
        ctx.close();
    }
}
