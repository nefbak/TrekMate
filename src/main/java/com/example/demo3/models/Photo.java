package com.example.demo3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private int uid;
    private int tid;
    private String filename;

    public Photo() {
    }

    @Transient
    public String getPhotosImagePath() {
        if (filename == null) return null;
         
        return "/upload-dir/" + filename;
    }

    public Photo(int uid, int tid, String filename) {
        this.uid = uid;
        this.tid = tid;
        this.filename = filename;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}