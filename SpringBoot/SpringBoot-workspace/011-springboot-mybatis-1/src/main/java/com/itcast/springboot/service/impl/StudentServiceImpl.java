package com.itcast.springboot.service.impl;

import com.itcast.springboot.mapper.StudentMapper;
import com.itcast.springboot.model.Student;
import com.itcast.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
