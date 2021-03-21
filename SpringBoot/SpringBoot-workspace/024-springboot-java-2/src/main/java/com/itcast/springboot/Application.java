package com.itcast.springboot;

import com.itcast.springboot.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 获取spring容器的第二种方式
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SomeService someService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        String hello = someService.hello();
        System.out.println(hello);
    }
}
