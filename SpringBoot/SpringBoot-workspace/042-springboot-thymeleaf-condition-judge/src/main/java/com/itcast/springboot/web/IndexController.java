package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("sex",1);
        model.addAttribute("flag",true);
        model.addAttribute("status",2);
        return "index";
    }
}
