package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.SeatRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString

public class Seat {
    //Andrea Brinkbøl
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    int seatRow;

    @Column
    int seatNumber;


    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "cinema_hall_id",referencedColumnName = "id")
    private CinemaHall cinemaHall;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showseat_id", referencedColumnName = "id")
    private ShowSeat showSeat;

    @ManyToOne(cascade = CascadeType.ALL)
    private Reservation reservation;


    public Seat(int seatRow, int seatNumber, CinemaHall cinemaHall) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.cinemaHall=cinemaHall;
    }

   /* @ManyToMany(mappedBy = "seatsReserved")
    private Set<Reservation> reservations= new HashSet<>();*/


    public Seat() {
    }


    public Seat(SeatRequest body) {
        this.seatRow = body.getSeatRow();
        this.seatNumber = body.getSeatNumber();
    }
}
