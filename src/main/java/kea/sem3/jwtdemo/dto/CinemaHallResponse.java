package kea.sem3.jwtdemo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.entity.Showing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CinemaHallResponse {

    private int numbSeats;
    private int numbRows;
    private Set<Showing> showings;
    private Set<Seat> seats;

    public CinemaHallResponse(CinemaHall ch){
        this.numbSeats= ch.getNumbSeats();
        this.numbRows= ch.getNumbRows();
        this.showings= ch.getShowings();
        this.seats=ch.getSeats();

    }

    public static List<CinemaHallResponse> getCinemaHallFromEntities(List<CinemaHall> cinemaHalls){
        return cinemaHalls.stream().map(cinemaHall -> new CinemaHallResponse(cinemaHall)).collect(Collectors.toList());

    }
}
