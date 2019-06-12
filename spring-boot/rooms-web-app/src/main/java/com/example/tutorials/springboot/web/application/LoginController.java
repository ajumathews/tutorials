package com.example.tutorials.springboot.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET,value = "/login")
    public String gerLoginPage(){
        return "login";
    }
}
