package com.zjts.buscenter;

import com.zjts.buscenter.netty.listener.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = "com.zjts")
public class BuscenterApplication implements CommandLineRunner {
    @Resource
    private NettyServer nettyServer;
    public static void main(String[] args) {
        SpringApplication.run(BuscenterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nettyServer.start();
    }
}
