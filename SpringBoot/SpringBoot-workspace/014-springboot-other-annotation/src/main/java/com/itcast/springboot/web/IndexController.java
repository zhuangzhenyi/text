package com.itcast.springboot.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController //如果一个类中所有的方法返回的都是json格式，只能响应json（相当于@Controller加上@ResponseBody）
public class IndexController {


    /**
     * 刚方法支持get请求，也支持post请求
     * @return
     */
    @RequestMapping(value = "/index")
//    @ResponseBody
    public Object index(){
        return "index";
    }

    /**
     * 该方法只支持get请求
     * @return
     */
    @RequestMapping(value = "index1",method = RequestMethod.GET)
    public Object index1(){
        return "index1 get method";
    }

    /**
     * 该方法只支持get请求
     * @return
     * 通常使用在查询操作
     */
    @GetMapping(value = "index2")
    public Object index2() {
        return "index2 get method";
    }

    /**
     * 该方法只支持post请求
     * @return
     */
    @RequestMapping(value = "/index3",method = RequestMethod.POST)
    public Object index3(){
        return "index3 post method";
    }

    /**
     * 该方法只支持post请求，通常用于新增操作
     * @return
     */
    @PostMapping(value = "/index4")
    public Object index4(){
        return "index4 post method";
    }

    /**
     * 该方法只支持put请求
     * @return
     */
    @RequestMapping(value = "/index5",method = RequestMethod.PUT)
    public Object index5(){
        return "index5 put method";
    }

    /**
     * 通常用于更新操作（修改）
     * @return
     */
    @PutMapping(value = "/index6")
    public Object index6(){
        return "index6 put method";
    }

    @RequestMapping(value = "index7",method = RequestMethod.DELETE)
    public Object index7(){
        return "index7 delete method";
    }

    @DeleteMapping(value ="/index8")
    public Object index8(){
        return "index8 delete method";
    }
}
