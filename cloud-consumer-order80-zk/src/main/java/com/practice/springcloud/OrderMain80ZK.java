package com.practice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Alen0076
 * @date 2020/4/19_13:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80ZK {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80ZK.class, args);
    }
}
