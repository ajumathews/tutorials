package com.tutorial.springvalidation;


import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    public String test() {
        return "hello";
    }
}
