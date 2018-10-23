package com.zjts.buscenter.netty.listener;




import com.zjts.buscenter.netty.config.NettyConfig;
import com.zjts.buscenter.netty.filter.HeartBeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 服务启动监听器
 *
 * @author han zq
 */
@Component
public class NettyServer {

    private static final Logger LOGGER =  LoggerFactory.getLogger(NettyServer.class);

    /**
     * 创建bootstrap
     */
    ServerBootstrap serverBootstrap;
    /**
     * 初始化用于Acceptor的主"线程池"
     */
    EventLoopGroup boss ;
    /**
     * 初始化用于I/O工作的从"线程池"
     */
    EventLoopGroup work ;

    /**
     * NETT服务器配置类
     */
    @Resource
    private NettyConfig nettyConfig;

    /**
     * 业务线程池
     */
    static final EventExecutorGroup bizGroup = null;

    /**
     * 通道监听器
     */
    private ChannelFuture f;

    /**
     * 关闭服务器
     */
    @PreDestroy
    public void close() {
        LOGGER.info("关闭服务器....");
        //优雅退出
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }

    /**
     * 开启及服务端线程
     */
    public void start() {
        serverBootstrap = new ServerBootstrap();
        boss = new NioEventLoopGroup();
        work = new NioEventLoopGroup();
       /*
          group方法:
          初始化serverBootstrap实例,并且绑定接收线程池,和io线程池,
          channel方法:
          指定通道channel的类型，由于是服务端，故而是NioServerSocketChannel
          Option方法:
          BACKLOG用于构造服务端套接字ServerSocket对象，
          标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。
          如果未设置或所设置的值小于1，Java将使用默认值50。
        */
       serverBootstrap.group(boss,work).channel(NioServerSocketChannel.class).
               option(ChannelOption.SO_BACKLOG, nettyConfig.getBacklog())
               .handler(new LoggingHandler(LogLevel.INFO))
               //一个端口释放后会等待两分钟之后才能再被使用，
               // SO_REUSEADDR是让端口释放后立即就可以被再次使用
               .option(ChannelOption.SO_REUSEADDR, true)
               .childOption(ChannelOption.SO_REUSEADDR, true)
           //是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态
           // 并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活
               .childOption(ChannelOption.SO_KEEPALIVE, true);

       try {
           //设置子通道也就是SocketChannel的处理器， 其内部是作实际业务开发
           serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
               @Override
               protected void initChannel(SocketChannel sc) throws Exception {
                   //管道过滤器,主要作用是负责channelHandlerd的管理和事件的拦截与调度
                   ChannelPipeline pipeline = sc.pipeline();
                   //使用DelimiterBasedFrameDecoder特殊分隔符解码器 解决tcp中的沾包问题
                   pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                   //NettyMessageDecoder作用:对接收到的字节流信息进行解码,转换成对象
              //   pipeline.addLast(new NettyMessageDecoder());
                   ByteBuf delimiter = Unpooled.copiedBuffer("$".getBytes("UTF-8"));
                   pipeline.addLast(new DelimiterBasedFrameDecoder(10240,delimiter));
                   //设置超时时间如果180s没有交互关闭通道
                   pipeline.addLast(new IdleStateHandler(180, 60, 180, TimeUnit.SECONDS));
                   //StringDecoder将channel中的字节转换成utf8的字符串,心跳检测,
                   pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8))
                           .addLast(new HeartBeatHandler())
                           //加入业务线程池,对业务的处理放在业务线程中单独处理,提高业务的处理效率
                           .addLast(bizGroup,new ServerHandler());


               }

           });

           //绑定端口,同步等待端口成功
           f = serverBootstrap.bind(nettyConfig.getPort()).sync();
           LOGGER.info("netty服务器在[{}]端口启动监听", nettyConfig.getPort());
           //等待服务监听端口关闭
           f.channel().closeFuture().sync();

       }catch (Exception e){
           e.printStackTrace();
           LOGGER.error("出现异常[{}]",e.getMessage());
           boss.shutdownGracefully();
           work.shutdownGracefully();
           LOGGER.info("释放资源成功");
       }finally {
           //退出释放线程资源
           f.channel().close();
           bizGroup.shutdownGracefully();
           boss.shutdownGracefully();
           work.shutdownGracefully();
       }

    }





}
