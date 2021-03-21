package com.itcast.springboot.web;



import com.itcast.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping(value = "/expression")
    public String index(Model model){
        model.addAttribute("data","后台获取数据");
        model.addAttribute("flag",true);
        model.addAttribute("sex",1);

        User user = new User();
        user.setId(1001);
        user.setUsername("zhangsan");
        model.addAttribute("user",user);
        return "expression";
    }
}
