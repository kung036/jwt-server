package com.cos.jwtserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .addFilter(corsConfig.corsFilterBean()) // CORS 요청(@CrossOrigin(인증X), 시큐리티 필터에 등록 인증(O))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/v1/user/**").hasAnyRole("USER", "MANAGER", "ADMIN")
                                .requestMatchers("/api/v1/manager/**").hasAnyRole("MANAGER", "ADMIN")
                                .requestMatchers("/api/v1/admin/**").hasAnyRole("ADMIN")
                                .anyRequest().permitAll() // 그 외의 나머지 요청 권한 없어도 허용
//                                .anyRequest().authenticated() // 그 외의 나머지 요청 권한 필요
                )
        ;

        return http.build();
    }
}
