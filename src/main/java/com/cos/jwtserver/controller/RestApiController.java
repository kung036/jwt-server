package com.cos.jwtserver.controller;

import com.cos.jwtserver.model.User;
import com.cos.jwtserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestApiController {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @GetMapping
    public String index() {
        return "<h1>Index</h1>";
    }

    @GetMapping("home")
    public String home() {
        return "<h1>Home</h1>";
    }

    @PostMapping("token")
    public String token() {
        return "<h1>Token</h1>";
    }

    // 회원가입
    @PostMapping("join")
    public String join(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "회원가입 완료";
    }

    // User 권한만 접근 가능
    @GetMapping("/api/v1/user")
    public String user() {
        return "<h1>User</h1>";
    }

    // Admin, Manager 권한만 접근 가능
    @GetMapping("/api/v1/manager")
    public String manager() {
        return "<h1>Manager</h1>";
    }

    // Admin 권한만 접근 가능
    @GetMapping("/api/v1/admin")
    public String admin() {
        return "<h1>Admin</h1>";
    }
}
