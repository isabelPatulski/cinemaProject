package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.SeatRequest;
import kea.sem3.jwtdemo.dto.SeatResponse;
import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.SeatRepository;

import java.util.List;

public class SeatService {
    SeatRepository seatRepository;


    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public SeatResponse getSeat(int id){
        Seat seat = seatRepository.findById(id).orElseThrow(()->new Client4xxException("No seat with this id exists"));
        return new SeatResponse(seat);
    }

    public List<SeatResponse> getSeats(){
        List<Seat> seats = seatRepository.findAll();
        return SeatResponse.getSeatsFromEntities(seats);
    }


    //Ekstra klasser
    public SeatResponse addSeat(SeatRequest seatRequest) {
        Seat newSeat = seatRepository.save(new Seat(seatRequest));
        return  new SeatResponse(newSeat);
    }

    public SeatResponse editSeat(SeatRequest seatToEdit, int seatId){
        Seat seat = seatRepository.findById(seatId).orElseThrow(()-> new Client4xxException("No seat with provided ID found"));

        seatToEdit.setSeatRow(seatToEdit.getSeatRow());
        seatToEdit.setSeatNumber(seatToEdit.getSeatNumber());

        return  new SeatResponse(seatRepository.save(seat));
    }

    public void deleteSeat(int seatId) {
        seatRepository.deleteById(seatId);
    }

}
