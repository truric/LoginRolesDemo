package com.example.loginRolesDemo.Security.User;

import com.example.loginRolesDemo.Models.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class UserSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{
        http.antMatcher("/professor/**")
                .authorizeRequests().anyRequest().hasAuthority("PROFESSOR")
                .and()
                .formLogin()
                .loginPage("/login").usernameParameter("email") // on template add   name="email"   on email input tag
			.loginProcessingUrl("/login")  // template href path
			.defaultSuccessUrl("/professor-index")  // redirect after successful login, template/GetMapping name/route
			.permitAll()
                .and()
                .logout().logoutUrl("/professor/logout")
                .logoutSuccessUrl("/");

        return http.build();
//	now any User/Role can access the app without having to go through login page, which is the default behavior of spring security dep.
    }
}
