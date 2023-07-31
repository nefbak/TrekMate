package com.example.demo3.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;
   // private int[] uids;
    @ElementCollection
    private List<Integer> uids;
    private String date;
    private String name;
    private String location;
    private String trailName;
    private String difficulty;
    private int tid;
    private int size;
  
    public Group() {
    }

    public Group(List<Integer> uids, String date, String name, String location, String trailName, String difficulty, int tid, int size) {
        this.uids = uids;
        this.date = date;
        this.name = name;
        this.location = location;
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.tid = tid;
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public List<Integer> getUids() {
        return uids;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}