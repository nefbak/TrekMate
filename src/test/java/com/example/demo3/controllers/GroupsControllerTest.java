package com.example.demo3.controllers;


import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import com.example.demo3.models.Group;

class GroupsControllerTest {


    @Test
    void testAddGroup() {

        GroupsController groupsController = new GroupsController();

        HashMap<String, String> newgroup = new HashMap<>();
        newgroup.put("tiddd", "42");
        newgroup.put("uiddd", "42");
        Response response = new Response();
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("users/groupsAdd", groupsController.addGroup(newgroup, response, model, new Group()));
    }

/*
    @Test
    @Disabled
    void testJoinGroup() {

        GroupsController groupsController = new GroupsController();

        HashMap<String, String> newgroup = new HashMap<>();
        newgroup.put("gid", "42");
        newgroup.put("uiddd", "42");
        Response response = new Response();
        ConcurrentModel model = new ConcurrentModel();
        groupsController.joinGroup(newgroup, response, model, new Group());
    }

    @Test
    @Disabled
    void testGetAllGroups() {

        GroupsController groupsController = new GroupsController();

        HashMap<String, String> newgroup = new HashMap<>();
        newgroup.put("uiddd", "42");
        HttpServletResponse response = mock(HttpServletResponse.class);
        ConcurrentModel model = new ConcurrentModel();
        groupsController.getAllGroups(newgroup, response, model, new Group());
    }

    @Test
    @Disabled
    void testRemoveGroup() {

        GroupsController groupsController = new GroupsController();
        HashMap<String, String> newgroup = new HashMap<>();
        HttpServletResponse response = mock(HttpServletResponse.class);
        ConcurrentModel model = new ConcurrentModel();
        groupsController.removeGroup(newgroup, response, model, new Group());
    }
*/

}

