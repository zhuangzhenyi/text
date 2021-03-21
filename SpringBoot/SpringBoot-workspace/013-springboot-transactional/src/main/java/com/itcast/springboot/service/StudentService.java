package com.itcast.springboot.service;

import com.itcast.springboot.model.Student;

public interface StudentService {

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int modifyStudentById(Student student);

    /**
     * 根据学生标识获取学生信息
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}
