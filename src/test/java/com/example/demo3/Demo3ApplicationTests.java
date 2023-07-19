package com.example.demo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo3.controllers.UsersController;
import com.example.demo3.models.User;
import com.example.demo3.models.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.jayway.jsonpath.JsonPath.*;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
class Demo3ApplicationTests {

	@Test
	void contextLoads() {
	}

}
/*@SpringBootTest
class Demo3ApplicationTests {

	@SpringBootTest
	public class SmokeTest {

		@Autowired
		private UsersController controller;


		@Test
		void contextLoads() throws Exception{
			assertThat(controller).isNotNull();
		}
	}
	
	
	@Test
	void contextLoads() {
	}

} */

/*@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterUseCaseIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private UserRepository userRepository;

  @Test
  void registrationWorksThroughAllLayers() throws Exception {
    User user = new User(10, "Wyoming", "Tommy", "tex@gmail.com", "maria", "7");

    mockMvc.perform(post("/forums/{forumId}/register", 42L)
            .contentType("application/json")
            .param("sendWelcomeMail", "true")
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isOk());

    List<User> users = userRepository.findByName("Zaphod");
    assertThat(user.getEmail()).isEqualTo("zaphod@galaxy.net");
  }

} */

/*@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private BookService bookService;
 
    @Test
    public void testGetAllBooks() throws Exception {
        Book book1 = new Book(1L, "Animal Farm", "George Orwell");
        Book book2 = new Book(2L, "1984", "George Orwell");
        List<Book> books = Arrays.asList(book1, book2);
 
        when(bookService.getAllBooks()).thenReturn(books);
 
        mockMvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Animal Farm")))
                .andExpect(jsonPath("$[0].author", is("George Orwell")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("1984")))
                .andExpect(jsonPath("$[1].author", is("George Orwell")));
    }
} */
 /*
@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // test the createBook endpoint
    @Test
    public void testRegister() throws Exception {
        // create a mock Book object for the request body
        User mockUser = new User(10, "Wyoming", "Tommy", "tex@gmail.com", "maria", "7");

        // perform a POST request to the endpoint with the mock Book object as the request body
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(mockUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uid", notNullValue()))
                .andExpect(jsonPath("$.title", is("To Kill a Mockingbird")))
                .andExpect(jsonPath("$.author", is("Harper Lee")));
    }
} */
