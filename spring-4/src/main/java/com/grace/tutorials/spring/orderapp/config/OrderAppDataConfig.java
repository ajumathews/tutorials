package com.grace.tutorials.spring.orderapp.config;

import com.grace.tutorials.spring.orderapp.data.CustomerRepository;
import com.grace.tutorials.spring.orderapp.data.InventoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderAppDataConfig {

    @Bean
    public InventoryRepository inventoryRepository() {
        return new InventoryRepository();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository();
    }

}
