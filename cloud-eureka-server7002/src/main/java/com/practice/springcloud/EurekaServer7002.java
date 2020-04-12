package com.practice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Alen0076
 * @date 2020/4/12_10:01
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class, args);
    }
}
