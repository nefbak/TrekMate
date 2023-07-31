package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Integer> {
    /*List<Review> findByRid(int id);
    List<Review> findByTid(int id);*/
    List<Friend> findByUid(int id);
    //List<Review> findByName(String name);
}
