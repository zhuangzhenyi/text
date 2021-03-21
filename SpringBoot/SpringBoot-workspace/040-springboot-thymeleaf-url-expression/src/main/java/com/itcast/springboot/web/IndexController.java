package com.itcast.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("id",9999);
        model.addAttribute("age",27);
        return "index";
    }

    @RequestMapping(value = "/index1")
    public @ResponseBody String index1(){
        return "index1";
    }

    @RequestMapping(value = "/index2")
    public @ResponseBody Object index2(Integer id){
        return "ID:"+id;
    }
    @RequestMapping(value = "/index3")
    public @ResponseBody Object index3(Integer id,Integer age){
        return "ID:"+id+",age:"+age;
    }

    @RequestMapping(value = "/index4")
    public String index4(){
        return "src";
    }

    @RequestMapping(value = "/index5")
    public String index5(Model model){
        model.addAttribute("id",888);
        return "form";
    }

    @RequestMapping(value = "/form")
    public @ResponseBody Object form(Integer id,String username){
        return "ID:"+id+"---username="+username;
    }
}
