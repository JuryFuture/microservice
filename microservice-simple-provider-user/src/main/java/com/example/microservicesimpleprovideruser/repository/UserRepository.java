package com.example.microservicesimpleprovideruser.repository;

import com.example.microservicesimpleprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
