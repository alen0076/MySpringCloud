package com.practice.springcloud.controller;

import com.practice.springcloud.entities.CommonResult;
import com.practice.springcloud.entities.Payment;
import com.practice.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Alen0076
 * @date 2020/4/11_17:32
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("Payment 插入");
        if (result > 0) {
            return new CommonResult<>(200, "新增成功", result);
        } else {
            return new CommonResult<>(400, "新增Payment失败", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentByID(id);
        log.info("获取 Payment");
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(400, "查询无数据", null);
        }
    }

}
