package com.itcast.springboot.dubbo.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
//@Service  相当于dubbo:service interface="" ref="" version="" timeout=""
@Service(interfaceClass = SomeService.class,version = "1.0.0",timeout = 35000)
public class SomeServiceImpl implements  SomeService{

    @Override
    public String hello() {
        return "Hello SpringBoot集成Dubbo";
    }
}
