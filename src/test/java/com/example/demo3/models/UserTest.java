package com.example.demo3.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testCustomConstructorEmpty() {
        User actualUser = new User();
        actualUser.setAge(1);
        actualUser.setDifficulty("Difficulty");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setLocation("Location");
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        actualUser.setUid(1);

        assertEquals(1, actualUser.getAge());
        assertEquals("Difficulty", actualUser.getDifficulty());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Location", actualUser.getLocation());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals(1, actualUser.getUid());
    }


    @Test
    void testCustomConstructorWithVal() {
        User actualUser = new User(1, "Location", "Name", "jane.doe@example.org", "iloveyou", "Difficulty");

        actualUser.setAge(1);
        actualUser.setDifficulty("Difficulty");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setLocation("Location");
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        actualUser.setUid(1);

        assertEquals(1, actualUser.getAge());
        assertEquals("Difficulty", actualUser.getDifficulty());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Location", actualUser.getLocation());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals(1, actualUser.getUid());
    }
}

