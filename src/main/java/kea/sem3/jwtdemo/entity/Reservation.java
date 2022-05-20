package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.ReservationRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numbOfSeats;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;

    /*der kan være mange reservationer til en fremvisning
    /*name er navngivning af den kollen der skal oprettes
    referencedColumnName er fra hvilken kolonne inforationen skal hentes fra
    informationen hentes fra showing-table og specifikt fra kolonen der hedder id,
    som ligger i showing table */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Showing showing;



    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER )
    private Movie movie;

    public Reservation(int numbOfSeats, Showing showing, Customer customer) {
        this.numbOfSeats = numbOfSeats;
        this.showing=showing;
        this.customer = customer;
    }

    public Reservation() {
    }


}
