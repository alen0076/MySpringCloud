package com.practice.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alen0076
 * @date 2020/4/19_15:01
 */
@Configuration
public class MySelfRole {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
