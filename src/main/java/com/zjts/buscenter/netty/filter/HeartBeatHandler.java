package com.zjts.buscenter.netty.filter;

import com.zjts.buscenter.netty.config.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  心跳检测
 */
public class HeartBeatHandler  extends ChannelDuplexHandler {
    private static Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("心跳检测功能已经开启");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("心跳检测功能已经关闭");
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.WRITER_IDLE) { // 180s
                // throw new Exception("idle exception");
                logger.info("idle 20s, send heartbeat");
                ByteBuf buf = Unpooled.copiedBuffer(Constants.HEATBEAT_MSG.getBytes(CharsetUtil.UTF_8));
                ctx.writeAndFlush(buf);
            }else if (state == IdleState.READER_IDLE) { // 180s
                logger.info("readtimesout超时,请求关闭 " + ctx.channel());
                ctx.close();
            }
            // 注意事项：
            // 因为我实现的逻辑是所有IdleStateEvent只由NettyHeartBeatHandler一个Handler处理即可；
            // 所以可以不需要将事件继续向pipeline后续的Handler传递，当然传递了也没什么事，因为其他的地方不能处理；
            // 在某些情况下，如果你定义的事件需要通知多个Handler处理，那么一定要加上下面这一句才行。
            super.userEventTriggered(ctx, evt);
        }else {
            // 其他事件转发给Pipeline中其他的Handler处理
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        if(message.startsWith("^HT")){
            logger.info("检测到心跳");
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("出现异常[{}]",cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }
}
