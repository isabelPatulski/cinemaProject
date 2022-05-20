package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReservationResponse {

    private String customerMail;
    private String movieTtitle;
    private int cinemaHallId;
    private int numbSeats;

    public ReservationResponse(Reservation res){
        this.customerMail= res.getCustomer().getEmail();
        this.movieTtitle = res.getShowing().getMovie().getTitle();
        this.cinemaHallId = res.getShowing().getCinemaHall().getId();
        this.numbSeats= res.getNumbOfSeats();
    }

    public static List<ReservationResponse> getShowingsFromEntities(List<Reservation> reservations){
        return reservations.stream().map(reservation-> new ReservationResponse(reservation)).collect(Collectors.toList());
    }
}
