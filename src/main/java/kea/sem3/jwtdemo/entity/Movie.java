package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.convert.DurationFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 60)
    String title;

    @Column(length = 60)
    String genre;

    int price;

    int ageLimit;

    @Column(length = 10)
    String rating;

    @Column(length = 500)
    String description;


    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
   private Set<Showing> showings = new HashSet<>();

    public void addShowing(Showing sh){
        showings.add(sh);
        sh.setMovie(this);
    }

    public Movie() {}


    public Movie(String title, String genre, int price, String description, String rating, int ageLimit) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.ageLimit = ageLimit;
        this.rating = rating;

    }

    public Movie(MovieRequest body){
        this.title = body.getTitle();
        this.genre = body.getGenre();
        this.price = body.getPrice();
        this.description = body.getDescription();
        this.rating = body.getRating();
        this.ageLimit = body.getAgeLimit();
    }
    @Column(length = 60)
    String title;

    @Column(length = 60)
    String genre;

    int price;

    int ageLimit;

    @Column(length = 10)
    String rating;

    @Column(length = 500)
    String description;


    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;



    /*
    @OneToMany (mappedBy = "reservedMovie", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();



    public void addReservation(Reservation res){
        reservations.add(res);
    }

     */

}
