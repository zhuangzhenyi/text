package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public @ResponseBody Object index(){

        return "Hello SpringBoot Web Project";
    }
}
