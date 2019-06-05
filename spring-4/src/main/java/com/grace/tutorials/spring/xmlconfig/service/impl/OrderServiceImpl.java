package com.grace.tutorials.spring.xmlconfig.service.impl;

import com.grace.tutorials.spring.xmlconfig.data.CustomerRepository;
import com.grace.tutorials.spring.xmlconfig.data.InventoryRepository;
import com.grace.tutorials.spring.xmlconfig.service.OrderService;

public class OrderServiceImpl implements OrderService {


    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;


    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository) {
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    public void process() {
        System.out.println("process");
    }

}
