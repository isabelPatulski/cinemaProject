package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Seat;

import java.util.List;
import java.util.stream.Collectors;

public class SeatResponse {
    int seatRow;
    int seatNumber;
    CinemaHall cinemaHall;

    public SeatResponse(Seat seat){
        this.seatRow= seat.getSeatRow();
        this.seatNumber=seat.getSeatNumber();
        this.cinemaHall= seat.getCinemaHall();
    }

    public static List<SeatResponse> getSeatsFromEntities(List<Seat> seats){
        return seats.stream().map(seat-> new SeatResponse(seat)).collect(Collectors.toList());
    }

}
