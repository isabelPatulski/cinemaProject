package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.dto.ShowingResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationService reservationService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<ReservationResponse> getReservations () {
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservation(@PathVariable int id) throws Exception
    {
        return reservationService.getReservation(id);
    }

    @PostMapping
    ReservationResponse createReservation (@RequestBody ReservationRequest reservationRequest) {
        return reservationService.create(reservationRequest);}


    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){}

   /* @PutMapping("/{reservationId}/customer/{customerId}")
    Reservation customerReservations (
            @PathVariable int reservationId,
            @PathVariable int customerId
    ) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Customer customer = customerRepository.findById(customerId).get();
        reservation.makeReservation(customer);
        return reservationRepository.save(reservation);
    }*/
}