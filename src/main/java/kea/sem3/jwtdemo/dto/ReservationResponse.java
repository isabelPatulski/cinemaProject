package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.entity.Showing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReservationResponse {


    private Showing showing;


    public ReservationResponse(Reservation res){
        this.showing=res.getShowing();
    }

    public static List<ReservationResponse> getShowingsFromEntities(List<Reservation> reservations){
        return reservations.stream().map(reservation-> new ReservationResponse(reservation)).collect(Collectors.toList());
    }
}
