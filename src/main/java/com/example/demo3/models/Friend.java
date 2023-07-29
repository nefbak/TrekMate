package com.example.demo3.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    @ElementCollection
    private List<Integer> fuids;
    private int uid;
    private String uname;
    @ElementCollection
    private List<String> names;

  
    public Friend() {
    }

    public Friend(List<Integer> fuids, int uid, String uname, List<String> names) {
        this.fuids = fuids;
        this.uid = uid;
        this.uname = uname;
        this.names = names;
    }

    public List<Integer> getFuids() {
        return fuids;
    }

    public void setFuids(List<Integer> fuids) {
        this.fuids = fuids;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    
}