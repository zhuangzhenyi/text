package com.itcast.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 关闭logo
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);

        springApplication.setBannerMode(Banner.Mode.OFF);

        springApplication.run(args);
    }

}
