package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.CustomerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//Skal ændres til customer
@Table(name = "costumer")
@Getter
@Setter
@ToString

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank String username;
    @NotBlank String email;
    private @NotBlank String password;
    @NotBlank int birthday;
    @NotBlank boolean loggedIn;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations = new HashSet <>();


    public Customer(int id, String username, String email, int birthday, String password, boolean loggedIn) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.loggedIn = false;
    }

    public Customer() {

    }

    public Customer(CustomerRequest body) {
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer user = (Customer) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password,
                loggedIn);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}