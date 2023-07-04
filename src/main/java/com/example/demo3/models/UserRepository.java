package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User,Integer> {
    // List<User> findById(String id);
}
