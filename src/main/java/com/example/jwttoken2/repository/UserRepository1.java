package com.example.jwttoken2.repository;

import com.example.jwttoken2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository1 extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String  email);
}
