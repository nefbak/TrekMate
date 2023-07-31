package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PhotoRepository extends JpaRepository<Photo, Integer>{
    List<Photo> findByUid(int uid);
    List<Photo> findByTid(int tid);
}