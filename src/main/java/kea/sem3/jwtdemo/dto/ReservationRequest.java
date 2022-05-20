package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    private int customerId;

    private int showingId;

    /*En liste af seatId, som er reseveret
    Listen skal gerne indeholde en liste over de seatId som er blevet reseveret*/
    private int numbOfSeats;

}
