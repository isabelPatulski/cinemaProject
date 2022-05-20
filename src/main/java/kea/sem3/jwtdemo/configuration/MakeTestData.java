package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.repositories.*;
;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {



    MovieRepository movieRepository;
    CinemaHallrepository cinemaHallrepository;
    ShowingRepository showingRepository;
    ReservationRepository reservationRepository;
    CustomerRepository customerRepository;


    public MakeTestData(MovieRepository movieRepository, CinemaHallrepository cinemaHallrepository, ShowingRepository showingRepository, ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.movieRepository = movieRepository;
        this.cinemaHallrepository = cinemaHallrepository;
        this.showingRepository = showingRepository;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    public  void makePlainTestData(){


//Movies

Movie m1= movieRepository.save(new Movie("The Lost City", "Horror", "This is a description", "PG-13", 13));
Movie m2= movieRepository.save(new Movie("The Batman", "Comedy", "This is a description", "PG", 7));

//Halls
        CinemaHall ch1 = new CinemaHall(10);
        cinemaHallrepository.save(ch1);

        CinemaHall ch2 = new CinemaHall(30);
        cinemaHallrepository.save(ch2);



        //Showings
        //Først skal det opretet showing-objekt gemmes
        Showing sh1 = showingRepository.save(new Showing(LocalDate.of(2022,5,14), LocalTime.of(12,00),90));

        //Her tilføjer en showing til en bestemt hall, hall ch1
        ch1.addShowing(sh1);

        //Her tilføjer vi en bestemt film til en bestemt showing/visning
        m1.addShowing(sh1);

        /*Herefter skal de nye tilføjelser gemmes.
        For at gemme de nye tilføjelser af film og hal, skal showing gemmes efter de to elementer er tilføjet
        Ellers gemmes de nye tilføjelser ikke til den nyoprettet showing*/
        showingRepository.save(sh1);

        Showing sh2 =showingRepository.save(new Showing(LocalDate.of(2022,9,15), LocalTime.of(3,00),90));
        ch1.addShowing(sh2);
        m1.addShowing(sh2);
        showingRepository.save(sh2);

        Showing sh3 = showingRepository.save(new Showing(LocalDate.of(2022,7,13), LocalTime.of(1,00),20));
        ch1.addShowing(sh3);
        m1.addShowing(sh3);
        showingRepository.save(sh3);

        Showing sh4 = showingRepository.save(new Showing(LocalDate.of(2022,12,01), LocalTime.of(2,00),40));
        ch1.addShowing(sh4);
        m1.addShowing(sh4);
        showingRepository.save(sh4);

        Showing sh5 = showingRepository.save(new Showing(LocalDate.of(2022,11,30), LocalTime.of(2,00),12));
        ch1.addShowing(sh5);
        m1.addShowing(sh5);
        showingRepository.save(sh5);

        Showing sh6 = showingRepository.save(new Showing(LocalDate.of(2022,9,22), LocalTime.of(2,00),90));
        ch1.addShowing(sh6);
        m1.addShowing(sh6);
        showingRepository.save(sh6);

        Showing sh7 = showingRepository.save(new Showing(LocalDate.of(2022,6,10), LocalTime.of(2,00),90));
        ch1.addShowing(sh7);
        m1.addShowing(sh7);
        showingRepository.save(sh7);

        Showing sh8 = showingRepository.save(new Showing(LocalDate.of(2022,4,16), LocalTime.of(2,00),90));
        ch2.addShowing(sh8);
        m2.addShowing(sh8);
        showingRepository.save(sh8);

        Showing sh9 = showingRepository.save(new Showing(LocalDate.of(2022,2,17), LocalTime.of(2,00),90));
        ch2.addShowing(sh9);
        m2.addShowing(sh9);
        showingRepository.save(sh9);

        Showing sh10 = showingRepository.save(new Showing(LocalDate.of(2022,1,14), LocalTime.of(2,00),90));
        ch2.addShowing(sh10);
        m2.addShowing(sh10);
        showingRepository.save(sh10);

        //Customer
        //String username, String surname, String email, int birthday
        Customer c1 = new Customer("kurt", "kitty", "kit@mail.dk", Date.(2022,4,16);
        Customer c2 = new Customer("Ask", "Ask", "A@mail.dk", 27);
        Customer c3 = new Customer("Zizi", "zizi", "z@mail.dk", 37);

        //Reservations
        //samme princip som i showing, med at gemme to gange gør sig også gældende her i reservation
        Reservation r1= reservationRepository.save(new Reservation());
        sh1.addReservation(r1);
        r1.setNumbOfSeats(10);
        reservationRepository.save(r1);

        Reservation r2= reservationRepository.save(new Reservation());
        sh1.addReservation(r2);
        r2.setNumbOfSeats(44);
        reservationRepository.save(r2);

        Reservation r3= reservationRepository.save(new Reservation());
        sh10.addReservation(r3);
        r3.setNumbOfSeats(80);
        reservationRepository.save(r3);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //og herefter oprettes nye tabeller med data fra makePlainTestData-metoden
        /* movieRepository.deleteAll();
        cinemaHallrepository.deleteAll();
        showingRepository.deleteAll();
        reservationRepository.deleteAll(); */
        makePlainTestData();


    }
}
