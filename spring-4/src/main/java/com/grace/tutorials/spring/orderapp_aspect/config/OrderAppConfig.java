package com.grace.tutorials.spring.orderapp_aspect.config;

import com.grace.tutorials.spring.orderapp_aspect.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.grace.springOrderAppAspect")
@EnableAspectJAutoProxy
public class OrderAppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrderAppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.processOrder();
        orderService.getOrderName(1);
    }
}
