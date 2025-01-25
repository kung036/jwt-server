package com.cos.jwtserver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter 존재함
// /login 요청 시 username, password 전송(POST) 하면
// UsernamePasswordAuthenticationFilter 동작함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    // /login 요청 을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter 로그인 시도중");

        // 1. username과 password 받아서

        // 2. 정상인지 로그인 시도를 해봄
        // authenticationmanager로 로그인 시도하면 PrincipalDetailsService가 호출됨
        // loadUserByUsernam()e이 자동으로 실행됨

        // 3. PrincipalDetails를 세션에 담고
        // 세션에 담는 이유 : 권한 관리를 위해서

        // 4. JWT 토큰을 만들어서 반환

        return super.attemptAuthentication(request, response);
    }
}
