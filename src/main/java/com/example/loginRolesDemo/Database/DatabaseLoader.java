package com.example.loginRolesDemo.Database;

import com.example.loginRolesDemo.Models.Role;
import com.example.loginRolesDemo.Models.User;
import com.example.loginRolesDemo.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    private final UserRepository userRepository;

    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("admin@gmail.com", "password", Role.ADMIN);
            User user2 = new User("admin2@gmail.com", "password", Role.ADMIN);
            User user3 = new User("prof@gmail.com", "password", Role.PROFESSOR);
            User user4 = new User("student@gmail.com", "password", Role.STUDENT);

            userRepository.saveAll(List.of(user1, user2, user3, user4));

            System.out.println("Database initialized");
        };
    }
}
