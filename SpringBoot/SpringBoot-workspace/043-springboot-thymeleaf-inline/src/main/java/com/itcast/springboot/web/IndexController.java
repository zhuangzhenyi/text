package com.itcast.springboot.web;


import com.itcast.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public  String index(Model model){

        User user = new User();
        user.setId(1001);
        user.setUsername("zhangkuang");
        model.addAttribute("user",user);
        return "index";
    }
}
