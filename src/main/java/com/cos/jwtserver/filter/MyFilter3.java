package com.cos.jwtserver.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");

        // 토큰 : cos 이걸 만들어줘야함. id, pw 정상적으로 들어와서 로그인이 완료되면 토큰 생성 후 응답
        // 요청할 때마다 header에 Authorization에 value 값으로 토큰을 가지고 옴
        // 그때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증하면 도미(RSA, HS256)
        if(req.getMethod().equals("POST")) {
            System.out.println("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);

            if(headerAuth != null && headerAuth.equals("cos")) {
                chain.doFilter(req, res); // 다음 필터 진행
            } else {
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }
        }
        System.out.println("필터33");
    }
}
