package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.MovieResponse;
import kea.sem3.jwtdemo.service.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/movies")
public class MovieController {
        MovieService movieService;

        public MovieController(MovieService movieService) {
            this.movieService = movieService;
        }

        @GetMapping
        public List<MovieResponse> getMovies(){
            return movieService.getMovies();
        }

        @GetMapping("/{id}")
        public MovieResponse getMovie(@PathVariable int id) throws Exception {
            return movieService.getMovie(id);
        }

        @PostMapping
        public MovieResponse addMovie(@RequestBody MovieRequest body){
            return movieService.addMovie(body);
        }

        /*@PutMapping("/{id}")
        public MovieResponse editMovie(@RequestBody MovieRequest body, @PathVariable int id){
            return movieService.editMovie(body,id);
        }

        @PatchMapping ("/{id}/{newprice}")
        public void editTitle(@PathVariable int id,@PathVariable String newTitle) throws Exception {
            movieService.updateTitle(id,newTitle);
        }
        @PatchMapping ("/{id}/{newprice}")
        public void editGenre(@PathVariable int id,@PathVariable String newGenre) throws Exception {
            movieService.updateGenre(id,newGenre);
        }

        @DeleteMapping("/{id}")
        public void deleteMovie(@PathVariable int id){}*/

    }
