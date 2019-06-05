package com.grace.tutorials.spring.xmlconfig.config;

import com.grace.tutorials.spring.xmlconfig.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderAppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService != null ? "OK" : "Null");
    }
}
