package com.zjts.buscenter.netty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfig {

    //读取yml中配置
    @Value("${tcp.port}")
    private  int port;

    @Value("${tcp.readtimesout}")
    private int readtimesout;

    @Value("${tcp.writetimesout}")
    private int writetimesout;


    @Value("${tcp.backlog}")
    private int backlog;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public int getReadtimesout() {
        return readtimesout;
    }

    public void setReadtimesout(int readtimesout) {
        this.readtimesout = readtimesout;
    }

    public int getWritetimesout() {
        return writetimesout;
    }

    public void setWritetimesout(int writetimesout) {
        this.writetimesout = writetimesout;
    }
}
