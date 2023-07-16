package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByRid(int id);
    //List<Review> findByName(String name);
}
