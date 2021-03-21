package com.itcast.springboot.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.itcast.springboot.mapper.StudentMapper;
import com.itcast.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 35000)
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryAllStudentCount() {

        //首先去redis缓存中获取学生总人数
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        //判断是否为空
        if (null == allStudentCount){
            //设置同步代码块
            synchronized (this){
                //再次从redis缓存中获取学生总人数
                allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                //再次判断是否为空
                if (null == allStudentCount){
                    //去数据库查询
                    allStudentCount = studentMapper.selectAllStudentCount();
                    //并存放到redis缓存中
                    redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.SECONDS);
                }
            }
        }
        return allStudentCount;
    }

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.selectByPrimaryKey(id);
    }
}
