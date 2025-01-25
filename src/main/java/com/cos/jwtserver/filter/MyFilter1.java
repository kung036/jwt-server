package com.cos.jwtserver.filter;

import jakarta.servlet.*;
import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터11");
        chain.doFilter(request, response); // 다음 필터 진행
    }
}