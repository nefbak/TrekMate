package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrailRepository extends JpaRepository<Trail,Integer> {
    List<Trail> findByTid(int id);
    List<Trail> findByName(String name);
}
