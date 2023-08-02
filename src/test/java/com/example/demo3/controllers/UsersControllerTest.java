package com.example.demo3.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import com.example.demo3.models.User;

class UsersControllerTest {


    @Test
    void testRegister() {

        UsersController usersController = new UsersController();

        assertEquals("users/register", usersController.register(new ConcurrentModel()));
    }


    @Test
    void testGetAdd() {

        UsersController usersController = new UsersController();
        assertEquals("redirect:/welcome.html", usersController.getAdd(new ConcurrentModel()));
    }


    @Test
    void testAddUser() {

        UsersController usersController = new UsersController();

        HashMap<String, String> newuser = new HashMap<>();
        newuser.put((String) "name", "foo");
        newuser.put((String) "password", "foo");
        newuser.put((String) "email", (String) "admin@gmail.com");
        newuser.put((String) "location", "foo");
        newuser.put((String) "difficulty", "foo");
        newuser.put((String) "age", (String) "");
        Response response = new Response();
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("users/register", usersController.addUser(newuser, response, model,
                new User(1, "Location", "Name", "jane.doe@example.org", "iloveyou", "Difficulty")));
    }

    //all this tests has issue with userRepo
    /**
    @Test
    void testLogin() {

        UsersController usersController = new UsersController();
        HashMap<String, String> newuser = new HashMap<>();
        Response response = new Response();
        ConcurrentModel model = new ConcurrentModel();
        usersController.login(newuser, response, model,
    // age is first var
                new User(1, "Location", "Name", "jane.doe@example.org", "iloveyou", "Difficulty"));
    }


    @Test
    @Disabled
    void testSaveAdd() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();
        usersController.saveAdd(model, new User(1, "Location", "Name", "jane.doe@example.org", "iloveyou", "Difficulty"));
    }


    @Test
    void testViewUser() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();
        usersController.viewUser(model, "1234", new Response());
    }
 */


    /**

    @Test
    @Disabled
    void testViewUserOther() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();

        HashMap<String, String> newuser = new HashMap<>();
        newuser.put("uog", "42");
        newuser.put("uiddd", "42");
        usersController.viewUserOther(model, newuser, new Response());
    } */


    @Test
    @Disabled
    void testViewUserAdmin() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();
        usersController.viewUserAdmin(model, "1234", new Response());
    }

    @Test
    @Disabled
    void testRemoveUser() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();
        usersController.removeUser(model, 1, new Response());
    }

    @Test
    @Disabled
    void testEditedStudent() {

        UsersController usersController = new UsersController();
        ConcurrentModel model = new ConcurrentModel();
        HashMap<String, String> newuser = new HashMap<>();
        usersController.editedStudent(model, newuser, new Response());
    }

}

