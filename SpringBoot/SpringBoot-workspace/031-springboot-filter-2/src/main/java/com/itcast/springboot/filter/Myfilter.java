package com.itcast.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("您已经进入过滤器");
        chain.doFilter(request,response);
    }
}
