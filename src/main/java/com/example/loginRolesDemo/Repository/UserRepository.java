package com.example.loginRolesDemo.Repository;

import com.example.loginRolesDemo.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
