package com.grace.tutorials.springboot;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DemoHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.down().withDetail("reason", "testing").build();
    }
}
