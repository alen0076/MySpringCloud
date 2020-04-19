package com.practice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Alen0076
 * @date 2020/4/19_21:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderMainFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign80.class, args);
    }
}
