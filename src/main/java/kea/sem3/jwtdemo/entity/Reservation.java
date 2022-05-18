package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int movieId;
    int dateID;
    int customerId;
    //Skal vidst lige laves til date/time
    LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerId", referencedColumnName = "id")
    private Customer customer;

    public Reservation(int id, int movieId, int dateID, int customerId, LocalDate date) {
        this.id = id;
        this.movieId = movieId;
        this.dateID = dateID;
        this.customerId = customerId;
        this.date = date;
    }

    public Reservation() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void makeReservation(Customer customer) {
        this.customer = customer;
    }
}
