package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.entity.Showing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CinemaHallRequest {

    private int numbSeats;
    private int numbRows;
}
