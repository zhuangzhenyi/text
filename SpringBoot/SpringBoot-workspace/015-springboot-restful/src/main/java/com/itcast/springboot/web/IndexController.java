package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping(value = "/student/detail")
    public @ResponseBody Object studentDetail(Integer id){

        return "ID->"+id;
    }

    @GetMapping(value = "/student.detail/{id}")
    public @ResponseBody Object studentDetail1(@PathVariable("id") Integer id){
        return "ID->"+id;
    }

    //RESTful风格容易导致路径冲突，方法的请求方式一样，参数个数一样都会引发路径冲突，解决方法可以更改请求方式，或者更改请求路径
    @GetMapping(value = "/student.detail/{id}/{name}")
    public @ResponseBody Object studentDetail2(@PathVariable("id") Integer id,
                                               @PathVariable("name") String name){
        return "ID->"+id+"Name->"+name;
    }
    @PostMapping(value = "/student.detail/{id}/{address}")
    public @ResponseBody Object studentDetail3(@PathVariable("id") Integer id,
                                               @PathVariable("address") String address){
        return "ID->"+id+"address->"+address;
    }
}
