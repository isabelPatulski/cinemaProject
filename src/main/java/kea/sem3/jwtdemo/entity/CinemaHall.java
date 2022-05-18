package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString

public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int hallNumber;
    int seat;
    int seatRow;

    public CinemaHall(int id, int hallNumber, int seat, int row) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.seat = seat;
        this.seatRow = row;
    }

    public CinemaHall() {

    }
}
