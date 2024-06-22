package com.whitetern.vertxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class VertxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VertxDemoApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public String hello8080() {
        return "Hello! This page's port is 8080, not 8081 for Vert.x";
    }

}
