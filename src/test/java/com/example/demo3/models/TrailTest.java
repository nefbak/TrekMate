package com.example.demo3.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrailTest {

    @Test
    void testCustomConstructorEmpty() {
        Trail actualTrail = new Trail();
        actualTrail.setLat(10.0f);
        actualTrail.setLocation("Location");
        actualTrail.setLon(10.0f);
        actualTrail.setName("Name");
        actualTrail.setTid(1);

        assertEquals(10.0f, actualTrail.getLat());
        assertEquals("Location", actualTrail.getLocation());
        assertEquals(10.0f, actualTrail.getLon());
        assertEquals("Name", actualTrail.getName());
        assertEquals(1, actualTrail.getTid());
    }

    @Test
    void testCustomConstructorWithVal() {
        Trail actualTrail = new Trail("Name", 10.0f, 10.0f, "Location");
        actualTrail.setLat(10.0f);
        actualTrail.setLocation("Location");
        actualTrail.setLon(10.0f);
        actualTrail.setName("Name");
        actualTrail.setTid(1);

        assertEquals(10.0f, actualTrail.getLat());
        assertEquals("Location", actualTrail.getLocation());
        assertEquals(10.0f, actualTrail.getLon());
        assertEquals("Name", actualTrail.getName());
        assertEquals(1, actualTrail.getTid());
    }
}

