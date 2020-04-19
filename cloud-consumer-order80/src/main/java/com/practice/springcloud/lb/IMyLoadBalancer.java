package com.practice.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Alen0076
 * @date 2020/4/19_19:20
 */
public interface IMyLoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);
}
