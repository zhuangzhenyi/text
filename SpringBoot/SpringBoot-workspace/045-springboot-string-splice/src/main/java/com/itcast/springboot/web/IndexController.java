package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("totalRows",215);
        model.addAttribute("totalPage",22);
        model.addAttribute("currentPage",3);
        return "index";
    }
}
