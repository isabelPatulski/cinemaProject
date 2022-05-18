package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Showing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {
    int id;
    String title;
    String genre;
    String description;
    int price;
    int ageLimit;
    String rating;
    Set<Showing> showings;


    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime updated;

    public MovieResponse(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.description = movie.getDescription();
        this.price = movie.getPrice();
        this.ageLimit = movie.getAgeLimit();
        this.rating = movie.getRating();
        this.showings=movie.getShowings();

    }

    public static List<MovieResponse> getMoviesFromEntities(List<Movie> movie){
        return movie.stream().map(movies-> new MovieResponse(movies)).collect(Collectors.toList());
    }
}
