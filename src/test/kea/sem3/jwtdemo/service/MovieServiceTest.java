package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.MovieResponse;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieServiceTest {

    @Autowired
    MovieRepository movieRepository;

    MovieService movieService;

    static int movie1Id, movie2Id;

    @BeforeAll
    static void setup(@Autowired MovieRepository movieRepository){
        movieRepository.deleteAll();
        movie1Id = movieRepository.save(new Movie("The Green Man", "Horror", 80, "This is a description", "PG-13", 13)).getId();
        movie2Id = movieRepository.save(new Movie("The Yellow Man", "Adventure", 50, "This is also a description", "PG", 7)).getId();
    }

    @BeforeEach
    void setupService(){
        movieService = new MovieService(movieRepository);
    }

    @Test
    void getMovies() {
        List<MovieResponse> allMovies = movieService.getMovies();
        assertEquals(2,allMovies.size());
        assertEquals("The Green Man", allMovies.get(0).getTitle());
    }

    @Test
    void getMovie() throws Exception{
        MovieResponse movie = movieService.getMovie(1);
        String title = "The Green Man";
        assertEquals(title, movie.getTitle());
    }

    @Test
    void addMovie() {
        Movie newMovie = new Movie("The Green Man 2", "Horror", 89, "This is a description", "R", 16);
        MovieResponse movieResponse = movieService.addMovie(new MovieRequest(newMovie.getTitle(), newMovie.getGenre(), newMovie.getDescription(), newMovie.getPrice(), newMovie.getAgeLimit(), newMovie.getRating()));
        assertEquals(3,movieResponse.getId());
        assertEquals("The Green Man 2",movieResponse.getTitle());
    }

/*
    @Test
    void editMovie() {
    }

    @Test
    void updateTitle() {
    }

    @Test
    void updateGenre() {
    }
 */

    @Test
    void deleteMovie() {
        movieRepository.deleteById(1);
        List<MovieResponse> movieResponses = movieService.getMovies();
        assertEquals(1,movieResponses.size());
    }
}