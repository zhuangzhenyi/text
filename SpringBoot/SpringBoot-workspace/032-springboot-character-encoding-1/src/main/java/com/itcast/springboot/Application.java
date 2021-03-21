package com.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.itcast.springboot.servlet")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
