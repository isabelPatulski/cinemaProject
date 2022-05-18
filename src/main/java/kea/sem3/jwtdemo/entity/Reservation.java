package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.ReservationRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    int id;


    /*der kan være mange reservationer til en fremvisning
    /*name er navngivning af den kollen der skal oprettes
    referencedColumnName er fra hvilken kolonne inforationen skal hentes fra
    informationen hentes fra showing-table og specifikt fra kolonen der hedder id,
    som ligger i showing table */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showing_id", referencedColumnName = "id")
    private Showing showing;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showseat_id", referencedColumnName = "id")
    private ShowSeat showSeat;
    @JoinColumn(name="customerId", referencedColumnName = "id")
    private Customer customer;

   /* @ManyToMany(cascade = CascadeType.ALL)
    //TODO hvordan tilføjer man flere tabels på én table?
    // skal både have seat og showing samlet i denne tabel, hvordan gøres det?

    @JoinTable(
            name = "showSeat",
            joinColumns= @JoinColumn(name="reservation_id"),
          inverseJoinColumns = @JoinColumn(name="seat_id")
    )
    private Set<Seat> seatsReserved= new HashSet<>();
    */


    public Reservation() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void makeReservation(Customer customer) {
        this.customer = customer;
    }
}
