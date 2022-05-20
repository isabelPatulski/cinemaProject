package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.CustomerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(length = 100)
    String username;
    String email;
    Date birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet <>();
    public void addReservation(Reservation res){
        reservations.add(res);
        res.setCustomer(this);
    }


    public Customer(String username, String surname, String email, Date birthday) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }

    public Customer() {
    }

    public Customer(CustomerRequest body) {
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }


}