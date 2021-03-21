package com.itcast.springboot.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.itcast.springboot.model.Student;
import com.itcast.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @GetMapping(value = "/student/count")
    public String studentCount(Model model){
        //调用远程接口服务
        Integer allStudentCount =studentService.queryAllStudentCount();
        model.addAttribute("allStudentCount",allStudentCount);
        return "studentCount";
    }

    @GetMapping(value = "/student/detail/{id}")
    public String studentDetail(Model model,
                                @PathVariable("id") Integer id){
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }
}
