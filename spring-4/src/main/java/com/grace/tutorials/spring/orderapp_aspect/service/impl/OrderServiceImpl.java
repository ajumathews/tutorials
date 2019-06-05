package com.grace.tutorials.spring.orderapp_aspect.service.impl;

import com.grace.tutorials.spring.orderapp_aspect.aspect.Loggable;
import com.grace.tutorials.spring.orderapp_aspect.data.CustomerRepository;
import com.grace.tutorials.spring.orderapp_aspect.data.InventoryRepository;
import com.grace.tutorials.spring.orderapp_aspect.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class OrderServiceImpl implements OrderService {

    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository) {
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    @Loggable
    public void processOrder() {
        System.out.println("processing order");
    }

    @Loggable
    public String getOrderName(int orderId) {
        return "OrderName "+orderId;
    }

    @PostConstruct
    public void init(){
        System.out.println("App Started");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("App Shutdown");
    }
}
