package kea.sem3.jwtdemo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MovieControllerTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static int movie1Id, movie2Id;

    @BeforeEach
    public void setup() {
        movieRepository.deleteAll();
        movie1Id = movieRepository.save(new Movie("The Green Man", "Horror", 80, "This is a description", "PG-13", 13)).getId();
        movie2Id = movieRepository.save(new Movie("The Yellow Man", "Adventure", 50, "This is also a description", "PG", 7)).getId();
    }

    @Test
    void getMovies()  throws Exception {
        String title = "$[?(@.title == '%s')]";
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(title, "The Green Man").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(title, "The Yellow Man").exists())
                .andExpect(MockMvcResultMatchers.content().string(containsString("The Green Man")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("The Yellow Man")));

    }

    @Test
    void getMovie() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies/" + movie1Id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(movie1Id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Green Man"));
    }

    @Test
    public void testAddMovie() throws Exception {
        MovieRequest newMovie = new MovieRequest("The Green Man 2", "Horror", "This is a description", 60, 16, "PG-13");
        {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                            .contentType("application/json")
                            .accept("application/json")
                            //Transform DTO to Json format
                            .content(objectMapper.writeValueAsString(newMovie)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
            assertEquals(3, movieRepository.count());
        }
    }

    /*
    @Test
    void editMovie() throws Exception {
        //Updating price, rating and Age limit for movie2Id
        MovieRequest movieToEdit = new MovieRequest("The Yellow Man", "Adventure", "This is also a description", 85, 18, "R");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/movies/" + movie2Id)
                        .contentType("application/json")
                        .accept("application/json")
                        .content(objectMapper.writeValueAsString(movieToEdit)))
                .andExpect(status().isOk());
        Movie editMovieFromDB = movieRepository.findById(movie2Id).orElse(null);
        assertEquals(85, editMovieFromDB.getPrice());
        assertEquals("R", editMovieFromDB.getRating());
        assertEquals(18, editMovieFromDB.getAgeLimit());
    }

     */

    @Test
    void deleteMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/movies/" + movie1Id))
                .andExpect(status().isOk());
        assertEquals(2, movieRepository.findAll().size());
    }
}