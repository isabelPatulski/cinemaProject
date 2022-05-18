package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.MovieResponse;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
        MovieRepository movieRepository;

        public MovieService(MovieRepository movieRepository) {
            this.movieRepository = movieRepository;
        }

        public List<MovieResponse> getMovies(){
            List<Movie> movies =  movieRepository.findAll();
            return MovieResponse.getMoviesFromEntities(movies);
        }
        public MovieResponse getMovie(int id) throws Exception {
            Movie movie = movieRepository.findById(id).orElseThrow(()->new Client4xxException("No car with this id exists"));
            return new MovieResponse(movie);
        }
        public MovieResponse addMovie(MovieRequest body){
            Movie newMovie = movieRepository.save(new Movie(body));
            return new MovieResponse(newMovie);
        }
        /*public MovieResponse editMovie(MovieRequest movieToEdit, int movieId){
            Movie car = movieRepository.findById(movieId).orElseThrow(()-> new Client4xxException("No car with provided ID found"));
            car.setTitle(movieToEdit.getTitle());
            car.setCategory(movieToEdit.getCategory());
            return new MovieResponse(movieRepository.save(car));
        }*/

        //PATCH method for Title
        public void updateTitle(int movieId, String newTitle){
            Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new Client4xxException("No car with provided ID found"));
            movie.setTitle(newTitle);
            movieRepository.save(movie);
        }
    /*
        //PATCH for Category
        public void updateGenre(int movieId,String newGenre){
            Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new Client4xxException("No car with provided ID found"));
            movie.setCategory(newGenre);
            movieRepository.save(movie);
        }

        public void deleteMovie(int movieId) {
            movieRepository.deleteById(movieId);
        }*/
    }