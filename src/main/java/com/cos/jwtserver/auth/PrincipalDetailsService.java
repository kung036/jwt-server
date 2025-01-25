package com.cos.jwtserver.auth;

import com.cos.jwtserver.model.User;
import com.cos.jwtserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// http://localhost:8080/login -> loginForm.html
//   -> loginController.java -> PrincipalDetailsService.java -> loadUserByUsername -> PrincipalDetails.java
@Configuration
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new PrincipalDetails(user);
    }
}
