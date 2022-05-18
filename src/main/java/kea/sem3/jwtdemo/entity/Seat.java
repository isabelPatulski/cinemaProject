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

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int seatRow;
    int number;
    boolean available;

    public Seat(int id, int row, int number, boolean available) {
        this.id = id;
        this.seatRow = row;
        this.number = number;
        this.available = available;
    }

    public Seat() {

    }
}
