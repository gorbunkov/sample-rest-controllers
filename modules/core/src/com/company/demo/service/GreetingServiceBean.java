package com.company.demo.service;

import org.springframework.stereotype.Service;

@Service(GreetingService.NAME)
public class GreetingServiceBean implements GreetingService {

    @Override
    public String sayHi() {
        return "Hi!";
    }
}