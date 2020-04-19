package com.practice.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Alen0076
 * @date 2020/4/11_18:59
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getInfo() {
        return this.restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }

}
