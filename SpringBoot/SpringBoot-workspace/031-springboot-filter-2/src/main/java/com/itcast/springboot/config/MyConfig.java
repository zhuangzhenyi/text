package com.itcast.springboot.config;

import com.itcast.springboot.filter.Myfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new Myfilter());

        filterRegistrationBean.addUrlPatterns("/myfilter");
        return filterRegistrationBean;
    }
}
