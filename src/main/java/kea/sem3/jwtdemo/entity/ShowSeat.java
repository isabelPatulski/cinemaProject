package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="showSeat")
public class ShowSeat {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne(mappedBy = "showSeat")
    private  Seat seat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    public ShowSeat (Seat seat){
        this.seat= seat;
    }

    public ShowSeat(int id, Seat seat, Reservation reservation) {
        this.id = id;
        this.seat = seat;
        this.reservation = reservation;
    }

    public ShowSeat() {
    }
}
