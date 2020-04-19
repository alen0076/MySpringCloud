package com.practice.springcloud.service;

import com.practice.springcloud.entities.CommonResult;
import com.practice.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Alen0076
 * @date 2020/4/19_21:39
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id);
}
