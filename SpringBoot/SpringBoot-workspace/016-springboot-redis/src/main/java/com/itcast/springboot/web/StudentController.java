package com.itcast.springboot.web;


import com.itcast.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/count")
    public @ResponseBody Object studentCount(){

        //定义一个固定的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 1000; i++) {//模拟高并发
            //开启一个线程
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Integer allStudentCount = studentService.queryAllStudentCount();
                }
            });
//        }
        executorService.shutdown();

        Integer allStudentCount = studentService.queryAllStudentCount();
        return "学生总人数为："+ allStudentCount;
    }
}
