package com.example.demo3.models;

import jakarta.persistence.*;

@Entity
@Table(name="trails")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String name;
    private float lat;
    private float lon;
    private String location;

    public Trail() {
    }

    public Trail(String name, float lat, float lon, String location) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    
}
