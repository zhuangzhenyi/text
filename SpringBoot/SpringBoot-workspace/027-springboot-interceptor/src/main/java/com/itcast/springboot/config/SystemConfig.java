package com.itcast.springboot.config;


import com.itcast.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //只要类上加@Configuration，就说明此类是一个配置类，就相当于一个xml配置文件
public class SystemConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义要拦截的路径
        String[] addPathPatterns = {"/user/**"};

        //排除不需要拦截的路径
        String[] excludePathPatterns = {"/user/page/login","/user/login"};


        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
