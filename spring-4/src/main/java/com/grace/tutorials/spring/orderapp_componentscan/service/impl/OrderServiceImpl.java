package com.grace.tutorials.spring.orderapp_componentscan.service.impl;

import com.grace.tutorials.spring.orderapp_componentscan.data.InventoryRepository;
import com.grace.tutorials.spring.orderapp_componentscan.service.OrderService;
import com.grace.tutorials.spring.orderapp_componentscan.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository) {
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    public void process() {
        System.out.println("process");
    }

}
