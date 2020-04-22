package com.practice.springcloud.controller;

import com.practice.springcloud.entities.CommonResult;
import com.practice.springcloud.entities.Payment;
import com.practice.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Alen0076
 * @date 2020/4/11_17:32
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id) throws InterruptedException {
        Payment payment = paymentService.getPaymentByID(id);
        log.info("获取 Payment");
        TimeUnit.SECONDS.sleep(3);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功"+port, payment);
        } else {
            return new CommonResult<>(400, "查询无数据"+port, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost() + "\t" + instance.getUri());
            Map<String, String> metadata = instance.getMetadata();
            for (Map.Entry<String, String> entry : metadata.entrySet()) {
                log.info(entry.getKey() + "\t" + entry.getValue());
            }

        }

        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getLBPort() {
        return port;
    }

}
