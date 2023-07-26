package com.example.demo3.models;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String trailName;
    private String date;
    private String location;
    private String difficulty;
    private String paragraph;
    private int tid;
    private int uid;

    public Review() {
    }

    public Review(String trailName, String date, String location, String difficulty, String paragraph, int tid, int uid) {
        this.trailName = trailName;
        this.date = date;
        this.location = location;
        this.difficulty = difficulty;
        this.paragraph = paragraph;
        this.tid = tid;
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setName(String trailName) {
        this.trailName = trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
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

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    

    
}
