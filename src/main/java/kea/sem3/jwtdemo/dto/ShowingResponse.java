package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.entity.Showing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowingResponse {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDate date;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalTime time;

    int price;

    CinemaHall cinemaHall;

    Movie movie;


    public ShowingResponse(Showing showing){
        this.date=showing.getDate();
        this.time= showing.getTime();
        this.price=showing.getPrice();
        this.cinemaHall=showing.getCinemaHall();
        this.movie=showing.getMovie();
    }

    public static List<ShowingResponse> getShowingsFromEntities(List<Showing> showings){
        return showings.stream().map(showing-> new ShowingResponse(showing)).collect(Collectors.toList());
    }
}
