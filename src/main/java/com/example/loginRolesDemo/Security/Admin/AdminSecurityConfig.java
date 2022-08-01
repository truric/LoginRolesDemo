package com.example.loginRolesDemo.Security.Admin;

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
@Order(1)
public class AdminSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//  this is for testing purposes, anyway, TODO check on previous projects: Bcrypt"
    }
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/", "/index", "/home").permitAll();

        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .antMatchers("/professor").hasAnyAuthority("PROFESSOR")
                .antMatchers("/backOffice").hasAnyAuthority("ADMIN", "PROFESSOR")
                .antMatchers("/profile").hasAnyAuthority("PROFESSOR", "STUDENT")
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/login").usernameParameter("email") // on template add   name="email"   on email input tag
			.loginProcessingUrl("/login")  // template href path
            .defaultSuccessUrl("/")
			.permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

        return http.build();
//	now any User/Role can access the app without having to go through login page, which is the default behavior of spring security dep.
    }
}
