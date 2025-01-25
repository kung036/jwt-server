package com.cos.jwtserver.filter;


import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터33");
        chain.doFilter(request, response); // 다음 필터 진행
    }
}
