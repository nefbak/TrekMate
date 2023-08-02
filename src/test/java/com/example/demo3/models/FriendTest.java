package com.example.demo3.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FriendTest {

    @Test
    void testCustomConstructorEmpty() {
        Friend actualFriend = new Friend();
        actualFriend.setFid(1);

        ArrayList<Integer> fuids = new ArrayList<>();
        actualFriend.setFuids(fuids);

        ArrayList<String> names = new ArrayList<>();
        actualFriend.setNames(names);
        actualFriend.setUid(1);
        actualFriend.setUname("Uname");

        assertEquals(1, actualFriend.getFid());

        List<Integer> fuids2 = actualFriend.getFuids();
        assertSame(fuids, fuids2);

        List<String> names2 = actualFriend.getNames();
        assertEquals(names2, fuids2);
        assertSame(names, names2);
        assertEquals(fuids, names2);

        assertEquals(1, actualFriend.getUid());
        assertEquals("Uname", actualFriend.getUname());
    }


    @Test
    void testCustomConstructorWithVal() {
        ArrayList<Integer> fuids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        Friend actualFriend = new Friend(fuids, 1, "Uname", names);
        actualFriend.setFid(1);

        ArrayList<Integer> fuids2 = new ArrayList<>();
        actualFriend.setFuids(fuids2);

        ArrayList<String> names2 = new ArrayList<>();
        actualFriend.setNames(names2);
        actualFriend.setUid(1);
        actualFriend.setUname("Uname");

        assertEquals(1, actualFriend.getFid());

        List<Integer> fuids3 = actualFriend.getFuids();
        assertSame(fuids2, fuids3);
        assertEquals(fuids, fuids3);
        assertEquals(names, fuids3);

        List<String> names3 = actualFriend.getNames();
        assertEquals(names3, fuids3);
        assertSame(names2, names3);

        assertEquals(fuids, names3);

        assertEquals(names, names3);

        assertEquals(fuids2, names3);
        assertEquals(1, actualFriend.getUid());
        assertEquals("Uname", actualFriend.getUname());
    }
}

