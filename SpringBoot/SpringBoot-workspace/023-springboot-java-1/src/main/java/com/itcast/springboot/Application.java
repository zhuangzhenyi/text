package com.itcast.springboot;

import com.itcast.springboot.service.SomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 获取spring容器：第一种方式
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    //run方法返回的ConfigurableApplicationContext就相当于之前的ClassPathXmlApplicationContext spring容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        //获取spring容器中的对象
        SomeService someService = (SomeService) applicationContext.getBean("someServiceImpl");

	    //调用业务方法
        String hello = someService.hello();
        System.out.println(hello);
    }

}
