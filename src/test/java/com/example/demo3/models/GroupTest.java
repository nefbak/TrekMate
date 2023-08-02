package com.example.demo3.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GroupTest {

    @Test
    void testCustomConstructorEmpty() {
        Group actualGroup = new Group();
        actualGroup.setDate("2020-03-01");
        actualGroup.setDifficulty("Difficulty");
        actualGroup.setGid(1);
        actualGroup.setLocation("Location");
        actualGroup.setName("Name");
        actualGroup.setSize(3);
        actualGroup.setTid(1);
        actualGroup.setTrailName("Trail Name");
        ArrayList<Integer> uids = new ArrayList<>();
        actualGroup.setUids(uids);

        assertEquals("2020-03-01", actualGroup.getDate());
        assertEquals("Difficulty", actualGroup.getDifficulty());
        assertEquals(1, actualGroup.getGid());
        assertEquals("Location", actualGroup.getLocation());
        assertEquals("Name", actualGroup.getName());
        assertEquals(3, actualGroup.getSize());
        assertEquals(1, actualGroup.getTid());
        assertEquals("Trail Name", actualGroup.getTrailName());
        assertSame(uids, actualGroup.getUids());
    }


    @Test
    void testCustomConstructorWithVal() {
        ArrayList<Integer> uids = new ArrayList<>();
        Group actualGroup = new Group(uids, "2020-03-01", "Name", "Location", "Trail Name", "Difficulty", 1, 3);
        actualGroup.setDate("2020-03-01");
        actualGroup.setDifficulty("Difficulty");
        actualGroup.setGid(1);
        actualGroup.setLocation("Location");
        actualGroup.setName("Name");
        actualGroup.setSize(3);
        actualGroup.setTid(1);
        actualGroup.setTrailName("Trail Name");
        ArrayList<Integer> uids2 = new ArrayList<>();
        actualGroup.setUids(uids2);

        assertEquals("2020-03-01", actualGroup.getDate());
        assertEquals("Difficulty", actualGroup.getDifficulty());
        assertEquals(1, actualGroup.getGid());
        assertEquals("Location", actualGroup.getLocation());
        assertEquals("Name", actualGroup.getName());
        assertEquals(3, actualGroup.getSize());
        assertEquals(1, actualGroup.getTid());
        assertEquals("Trail Name", actualGroup.getTrailName());
        List<Integer> uids3 = actualGroup.getUids();
        assertSame(uids2, uids3);
        assertEquals(uids, uids3);
    }
}

