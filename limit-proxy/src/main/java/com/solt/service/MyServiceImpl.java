package com.solt.service;

import org.springframework.stereotype.Component;

@Component
public class MyServiceImpl implements  MyService{
    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
