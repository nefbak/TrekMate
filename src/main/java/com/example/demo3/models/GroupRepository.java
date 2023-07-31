package com.example.demo3.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group> findByGid(int id);
    List<Group> findByTid(int id);
    //List<Review> findByName(String name);
    //@Query(value = "select p from Group g WHERE :uid in elements(g.uids)", nativeQuery = true)
    //List<Group> getAllByUids(@Param("uid") String uid);

    //@Query(value = "SELECT g FROM Group g WHERE :uid IN elements(g.uids)", nativeQuery = true)
    //@Query(value = "SELECT * FROM Group WHERE ?1 IN (SELECT uids FROM Group)", nativeQuery = true)
    /*@Query(value = "SELECT * FROM Group WHERE :uid IN (SELECT uids FROM Group)", nativeQuery = true)
    List<Group> findByUids(@Param("uid") int uid);*/
    List<Group> findByUidsContaining(int uid);
}
