package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.CinemaHallRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString

public class CinemaHall {
    //Andrea & Isabel
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int numbSeats;
    int numbRows;

    //Connecter mellem showings & hall
    @OneToMany(mappedBy = "cinemaHall")
    private Set<Showing> showings = new HashSet<>();
    public void addShowing(Showing show) {
        showings.add(show);
        show.setCinemaHall(this);
    }

    //Connecter mellem seats & hall
    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.PERSIST)
    Set<Seat> seats = new HashSet<>();


    public CinemaHall(CinemaHallRequest body) {
        this.numbSeats = body.getNumbSeats();
        this.numbRows = body.getNumbRows();

    }

    public CinemaHall() {}

    public CinemaHall(int numbSeats, int numbRows) {
        this.numbSeats = numbSeats;
        this.numbRows = numbRows;
        for (int r = 1; r < numbRows; r++)
            for (int s = 1; s < numbSeats; s++) {
                seats.add(new Seat(r, s, this));
            }

    }
}
