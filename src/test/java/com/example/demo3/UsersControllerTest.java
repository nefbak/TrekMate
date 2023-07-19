package com.example.demo3;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo3.controllers.UsersController;
import com.example.demo3.models.User;
//import com.example.demo3.models.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
//import static com.jayway.jsonpath.JsonPath.*;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.junit.runner.RunWith;

//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.hamcrest.CoreMatchers.*;
/*import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List; */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // test the createUser endpoint
    @Test
    public void testRegister() throws Exception {
        // create a mock User object for the request body
        User mockUser = new User(10, "Wyoming", "Tommy", "tex@gmail.com", "maria", "7");

        // perform a POST request to the endpoint with the mock User object as the request body
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(mockUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uid", notNullValue()))
                .andExpect(jsonPath("$.name", is("Tommy")))
                .andExpect(jsonPath("$.location", is("Wyoming")));
    }
}
