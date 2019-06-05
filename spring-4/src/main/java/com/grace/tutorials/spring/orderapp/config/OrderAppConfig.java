package com.grace.tutorials.spring.orderapp.config;

import com.grace.tutorials.spring.orderapp.data.CustomerRepository;
import com.grace.tutorials.spring.orderapp.service.OrderService;
import com.grace.tutorials.spring.orderapp.service.impl.OrderServiceImpl;
import com.grace.tutorials.spring.orderapp.data.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(OrderAppDataConfig.class)
public class OrderAppConfig {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public OrderService orderService(InventoryRepository inventoryRepository, CustomerRepository customerRepository) {
        return new OrderServiceImpl(inventoryRepository, customerRepository);
    }



    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrderAppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService == null ? "NULL" : "OK");
        ((AnnotationConfigApplicationContext) context).close();


    }
}
