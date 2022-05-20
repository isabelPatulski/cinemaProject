package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.*;
import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.entity.Showing;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CinemaHallrepository;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    ShowingRepository showingRepository;
    MovieRepository movieRepository;
    CinemaHallrepository cinemaHallrepository;

    ReservationRepository reservationRepository;

    public ShowingService(ShowingRepository showingRepository, MovieRepository movieRepository, CinemaHallrepository cinemaHallrepository, ReservationRepository reservationRepository) {
        this.showingRepository = showingRepository;
        this.movieRepository = movieRepository;
        this.cinemaHallrepository = cinemaHallrepository;
        this.reservationRepository = reservationRepository;
    }

    public ShowingResponse getShowing(int id){
        Showing show = showingRepository.findById(id).orElseThrow(()-> new Client4xxException("No showing reservation id:" + id));
        return new ShowingResponse(show);
    }

    public List<ShowingResponse> getAllShowings(){
        return ShowingResponse.getShowingsFromEntities(showingRepository.findAll());
    }

    public ShowingResponse createShowing(ShowingRequest showingRequest){
    Movie movie = movieRepository.findById(showingRequest.getMovieId()).orElseThrow();
    CinemaHall cinemaHall= cinemaHallrepository.findById(showingRequest.getCinemaId()).orElseThrow();

    Showing showing = new Showing(showingRequest.getDate(),showingRequest.getTime(), movie, cinemaHall);
    ShowingResponse showingResponse = new ShowingResponse(showing);

    return showingResponse;
    }

    public void deleteShowing(int showingId) {
        showingRepository.deleteById(showingId);
    }

}
