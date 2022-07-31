package com.example.loginRolesDemo.Config.Admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class AdminSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/").permitAll();
        return http.build();
//	now any User/Role can access the app without having to go through login page, which is the default behavior of spring security dep.
    }
}
