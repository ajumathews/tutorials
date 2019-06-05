package com.grace.tutorials.spring.orderapp.service.impl;

import com.grace.tutorials.spring.orderapp.data.CustomerRepository;
import com.grace.tutorials.spring.orderapp.data.InventoryRepository;
import com.grace.tutorials.spring.orderapp.service.OrderService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OrderServiceImpl implements OrderService {

    @PostConstruct
    public void init(){
        System.out.println("App Started");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("App Shutdown");
    }

    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository) {
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    public void processOrder() {
        System.out.println("processing order");
    }
}
