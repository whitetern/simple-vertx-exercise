package com.whitetern.vertxdemo.config;

import com.whitetern.vertxdemo.vertx.VertxServer;
import io.vertx.core.Vertx;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertxDeploymentRunner {

    @Bean
    public ApplicationRunner deployVerticle(Vertx vertx, VertxServer vertxServer) {
        return args -> vertx.deployVerticle(vertxServer);
    }
}
