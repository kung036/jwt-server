package com.cos.jwtserver.config;

import org.springframework.web.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilterBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);           // 내서버가 응답할 때 json을 자바스크립트에서 처리할 수 있도록 설정함
        config.addAllowedOrigin("*");         // 모든 IP에 응답 허용
        config.addAllowedHeader("*");  // 모든 Header에 응답 허용
        config.addAllowedMethod("*");        // 모든 Method에 응답 허용
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }
}
