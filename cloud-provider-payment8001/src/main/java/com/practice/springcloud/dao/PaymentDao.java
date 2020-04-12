package com.practice.springcloud.dao;

import com.practice.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alen0076
 * @date 2020/4/11_12:30
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentByID(@Param("id") Long id);
}
