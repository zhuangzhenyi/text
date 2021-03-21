package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("data","Springboot框架集成JSP页面");
        return "index";
    }
}
