package com.itcast.springboot.web;

import com.itcast.springboot.model.City;
import com.itcast.springboot.model.School;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private School school;

    @Resource
    private City city;

    @RequestMapping("/school")
    public @ResponseBody Object school(){
        return "school.name="+school.getName()+",school.website="+school.getWebsite();
    }

    @RequestMapping("/city")
    public @ResponseBody Object city(){
        return "city.name="+city.getName()+",city.website="+city.getWebsite();
    }
}
