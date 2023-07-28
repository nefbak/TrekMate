package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group> findByGid(int id);
    List<Group> findByTid(int id);
    //List<Review> findByName(String name);
    @Query(value = "select p from Group g WHERE :uid in elements(g.uids)", nativeQuery = true)
    List<Group> getAllByUids(@Param("uid") String uid);
}