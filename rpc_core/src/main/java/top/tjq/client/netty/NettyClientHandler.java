package top.tjq.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by moling_tjq on 2020-09-04
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<entity.RpcRespone> {
    private static final Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, entity.RpcRespone msg) throws Exception {
        try {
            logger.info(String.format("客户端接收到消息: %s", msg));
            AttributeKey<entity.RpcRespone> key = AttributeKey.valueOf("rpcResponse");
            ctx.channel().attr(key).set(msg);
            ctx.channel().close();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("过程调用时有错误发生:");
        cause.printStackTrace();
        ctx.close();
    }
}
