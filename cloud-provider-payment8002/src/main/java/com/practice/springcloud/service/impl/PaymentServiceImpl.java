package com.practice.springcloud.service.impl;

import com.practice.springcloud.dao.PaymentDao;
import com.practice.springcloud.entities.Payment;
import com.practice.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alen0076
 * @date 2020/4/11_17:29
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentByID(Long id) {
        return paymentDao.getPaymentByID(id);
    }
}
