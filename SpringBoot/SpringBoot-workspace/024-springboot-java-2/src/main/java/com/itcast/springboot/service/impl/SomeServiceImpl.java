package com.itcast.springboot.service.impl;

import com.itcast.springboot.service.SomeService;
import org.springframework.stereotype.Service;


@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String hello() {


        return "Hello Springboot Java Project-2";
    }
}
