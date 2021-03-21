package com.itcast.springboot.web;


import com.itcast.springboot.mapper.StudentMapper;
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

    @RequestMapping(value = "update")
    public @ResponseBody Object update(Integer id,String studnetName){
        Student student = new Student();
        student.setId(id);
        student.setStuName(studnetName);
        int modifyCount = studentService.modifyStudentById(student);
        return "修改的结果：" + modifyCount;
    }


    @RequestMapping(value = "/student/detail")
    public @ResponseBody Object studentDetail(Integer id){

        Student student = studentService.queryStudentById(id);
        return student;
    }
}
