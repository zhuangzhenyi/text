package com.itcast.springboot.service.impl;

import com.itcast.springboot.mapper.StudentMapper;
import com.itcast.springboot.model.Student;
import com.itcast.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int modifyStudentById(Student student) {

        int modifyCount = studentMapper.updateByPrimaryKeySelective(student);

//        int a = 10/0;
        return modifyCount;
    }

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.selectByPrimaryKey(id);
    }
}
