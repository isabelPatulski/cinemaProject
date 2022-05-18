package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    //Store som id's for the test methods
    static int movie1, movie2;

    @BeforeAll
    static void setUp(@Autowired MovieRepository movieRepository) {
        movie1 = movieRepository.save(new Movie("The Green Man", "Horror", 80, "This is a description", "PG-13", 13)).getId();
        movie2 = movieRepository.save(new Movie("The Yellow Man", "Adventure", 50, "This is also a description", "PG", 7)).getId();
    }

    @Test
    void findMovieById() {
        Movie aNewMovie = movieRepository.findById(movie1).orElse(null);
        assertEquals("The Green Man",aNewMovie.getTitle());
    }
}