package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallrepository extends JpaRepository<CinemaHall, Integer> {

}
