package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.*;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.entity.Showing;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    ShowingRepository showingRepository;
    ReservationRepository reservationRepository;

    public ShowingResponse addShowing(ShowingRequest body){
        Showing newShowing = showingRepository.save(new Showing(body));
        return new ShowingResponse(newShowing);
    }

    public ShowingResponse getShowing(int id){
        Showing show = showingRepository.findById(id).orElseThrow(()-> new Client4xxException("No showing reservation id:" + id));
        return new ShowingResponse(show);
    }

    public List<ShowingResponse> getShowings(){
        List<Showing> showings= showingRepository.findAll();
        return ShowingResponse.getShowingsFromEntities(showings);
    }

}
