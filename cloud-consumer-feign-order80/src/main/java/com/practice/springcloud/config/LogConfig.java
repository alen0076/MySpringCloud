package com.practice.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alen0076
 * @date 2020/4/22_20:48
 */
@Configuration
public class LogConfig {

    @Bean
    public Logger.Level getLogLevel() {
        return Logger.Level.FULL;
    }
}
