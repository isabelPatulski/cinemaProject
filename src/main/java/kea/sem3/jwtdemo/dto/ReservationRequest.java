package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    //private  int costumerId;
    private int customerId;

    private int showingId;

    private int seatId;
}
