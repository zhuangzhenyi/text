package com.itcast.springboot.service.impl;

import com.itcast.springboot.mapper.StudentMapper;

import com.itcast.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Integer queryAllStudentCount() {
        //更新redisTemplte对象中spring容器中key的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //首先去redis缓存中查询
        /*Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");

        //判断是否有值
        if (null == allStudentCount){
            System.out.println("从数据库中查询。。。");
            //没有：去数据库擦汗讯，并存放到redis缓存中
            allStudentCount = studentMapper.selectAllStudentCount();
            //存放到redis缓存中
            redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.SECONDS);
        }else {
            System.out.println("从redis中查询。。。");
        }*/
        //以上代码在多线程高并发的时候，会出现一种现象叫做：缓存穿透
        //通过双重检测+同步代码块来解决以上问题
        //首先去redis缓存中获取学生总人数
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");

        //判断是否为空
        if (null ==allStudentCount){
            //设置同步代码块
            synchronized (this){
                //再次从Redis中获取学生总人数
                allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                //再次判断是否为空
                if (null == allStudentCount){
                    System.out.println("从数据库中查询。。。");
                    //没有：去数据库擦汗讯，并存放到redis缓存中
                    allStudentCount = studentMapper.selectAllStudentCount();
                    //存放到redis缓存中
                    redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.SECONDS);
                }else {
                    System.out.println("从redis中查询。。。");
                }
            }
        }else {
            System.out.println("从redis中查询。。。");
        }
        //有：直接返回
        return allStudentCount;
    }
}
