package com.practice.springcloud.lb.impl;

import com.practice.springcloud.lb.IMyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alen0076
 * @date 2020/4/19_19:11
 */
@Component
public class MyLoadBalancer implements IMyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = getNext() % instances.size();
        return instances.get(index);
    }


    private int getNext() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }

}
