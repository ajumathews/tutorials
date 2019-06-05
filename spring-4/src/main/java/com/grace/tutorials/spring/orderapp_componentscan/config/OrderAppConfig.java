package com.grace.tutorials.spring.orderapp_componentscan.config;

import com.grace.tutorials.spring.orderapp_componentscan.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.grace.tutorials.spring.orderapp_componentscan"})
public class OrderAppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrderAppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService == null ? "NULL" : "OK");

    }
}
