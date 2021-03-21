package com.itcast.springboot.web;


import com.itcast.springboot.model.Student;
import com.itcast.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/detail")
    public @ResponseBody Object studentDetail(Integer id){
        Student student = studentService.queryStudentById(id);
        return student;
    }
}
