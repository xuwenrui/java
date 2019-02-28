package com.frank.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 日志打印
 * @author: xu.wr
 * @create: 2019-02-27 09:40
 **/

@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public void logMethod() {
        LOG.info("==========print log==========");
    }
}
