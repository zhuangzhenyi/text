package com.itcast.springboot.service;


import com.itcast.springboot.model.Student;

public interface StudentService {
    /**
     * 获取学生总人数
     * @return
     */
    Integer queryAllStudentCount();

    /**
     * 根据学生标识获取学生详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}
