package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.convert.DurationFormat;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Getter @Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    String category;


    //TODO: spørge om hjælp til dette hos lars.
    // Duration duration =Duration.between()

    /*TODO kan først laves, når genre er blevet lavet
    @ManyToOne
    Genre movieGenre;*/

    public Movie() {}


    public Movie(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Movie(MovieRequest body){
        this(body.getId(), body.getTitle(), body.getCategory());
    }
}