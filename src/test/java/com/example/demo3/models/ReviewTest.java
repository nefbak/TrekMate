package com.example.demo3.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReviewTest {

    @Test
    void testCustomConstructorEmpty() {
        Review actualReview = new Review();
        actualReview.setDate("2020-03-01");
        actualReview.setDifficulty("Difficulty");
        actualReview.setLocation("Location");
        actualReview.setName("Trail Name");
        actualReview.setParagraph("Paragraph");
        actualReview.setRid(1);
        actualReview.setTid(1);
        actualReview.setTrailName("Trail Name");
        actualReview.setUid(1);

        assertEquals("2020-03-01", actualReview.getDate());
        assertEquals("Difficulty", actualReview.getDifficulty());
        assertEquals("Location", actualReview.getLocation());
        assertEquals("Paragraph", actualReview.getParagraph());
        assertEquals(1, actualReview.getRid());
        assertEquals(1, actualReview.getTid());
        assertEquals("Trail Name", actualReview.getTrailName());
        assertEquals(1, actualReview.getUid());
    }


    @Test
    void testCustomConstructorWithVal() {
        Review actualReview = new Review("Trail Name", "2020-03-01", "Location", "Difficulty", "Paragraph", 1, 1);
        actualReview.setDate("2020-03-01");
        actualReview.setDifficulty("Difficulty");
        actualReview.setLocation("Location");
        actualReview.setName("Trail Name");
        actualReview.setParagraph("Paragraph");
        actualReview.setRid(1);
        actualReview.setTid(1);
        actualReview.setTrailName("Trail Name");
        actualReview.setUid(1);

        assertEquals("2020-03-01", actualReview.getDate());
        assertEquals("Difficulty", actualReview.getDifficulty());
        assertEquals("Location", actualReview.getLocation());
        assertEquals("Paragraph", actualReview.getParagraph());
        assertEquals(1, actualReview.getRid());
        assertEquals(1, actualReview.getTid());
        assertEquals("Trail Name", actualReview.getTrailName());
        assertEquals(1, actualReview.getUid());
    }
}

