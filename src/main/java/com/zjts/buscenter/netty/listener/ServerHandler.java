package com.zjts.buscenter.netty.listener;

import com.zjts.buscenter.netty.config.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 业务处理器
 *
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

//    @Autowired
//    private BusService busService;

    private static int LONGINSTATE;
    static long  endTime;
    Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LONGINSTATE = 0;
        super.channelActive(ctx);

    }


    /**
        该方法为tcp连接建立之后的一些相关操作.
        该方法用作连接建立之后对车进行身份验证的操作,
        如果通过执行 login.如果不通过直接拒绝连接,并且记录相关日志信息保存到数据库
     */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(msg);
        String message = (String) msg;
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        //       LONGINSTATE = 0 登陆验证
        if (LONGINSTATE == 0){
      //      String logret =  busService.login(message);
            String logret = "验证登陆成功!";
            if(StringUtils.isEmpty(logret)){
                logger.info(new Date().toString()+" : 来自"+clientIP+"验证失败!");
                ctx.close();
            }
            ByteBuf buf = Unpooled.copiedBuffer(logret.getBytes(CharsetUtil.UTF_8));
            ctx.writeAndFlush(buf);
            LONGINSTATE =1;
        //日常业务
        }else if(LONGINSTATE == 1) {
           // busService.proceed(message);
            String logret = "日常数据接收成功!";
            System.out.println("服务器接收到日常业务消息:"+message);
            System.out.flush();
            if(!StringUtils.isEmpty(logret)){
            ByteBuf buf = Unpooled.copiedBuffer(logret.getBytes(CharsetUtil.UTF_8));
            ctx.writeAndFlush(buf);
            }


        }


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("数据读取已经完成");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("出现异常[{}]",cause.getMessage());
        ctx.close();
    }

}