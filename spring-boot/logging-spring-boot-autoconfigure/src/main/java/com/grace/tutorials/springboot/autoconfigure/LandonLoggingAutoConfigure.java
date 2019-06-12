package com.grace.tutorials.springboot.autoconfigure;

import com.grace.tutorials.springboot.aspect.LoggableAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(LoggableAspect.class)
@EnableConfigurationProperties(LandonLoggingProperties.class)
public class LandonLoggingAutoConfigure {

    @Autowired
    private LandonLoggingProperties landonLoggingProperties;

    @Bean
    public LoggableAspect loggableAspect(LandonLoggingProperties landonLoggingProperties) {
        return new LoggableAspect(landonLoggingProperties.getLoggerName());
    }
}
