package com.practice.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Alen0076
 * @date 2020/4/19_12:36
 */
@RestController
@Slf4j
public class PaymentZK {

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/payment/zk")
    public String paymentZK() {
        return "springCloud with zookeeper:" + port + "\t" + UUID.randomUUID().toString();
    }
}
