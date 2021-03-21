package com.itcast.springboot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Value("${school.name}")
    private String schoolName;

    @Value("${website}")
    private String website;

    @RequestMapping("/index")
    public @ResponseBody Object index(){
        return "schoolName:"+schoolName+",website:"+website;
    }
}
