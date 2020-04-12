package com.practice.springcloud.service;

import com.practice.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alen0076
 * @date 2020/4/11_17:28
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentByID(@Param("id") Long id);
}
