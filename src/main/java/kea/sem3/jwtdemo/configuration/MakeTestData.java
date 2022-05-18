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

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {



    MovieRepository movieRepository;
    CinemaHallrepository cinemaHallrepository;
    ShowingRepository showingRepository;
    SeatRepository seatRepository;
    ReservationRepository reservationRepository;


    public MakeTestData(MovieRepository movieRepository, CinemaHallrepository cinemaHallrepository, ShowingRepository showingRepository, SeatRepository seatRepository, ReservationRepository reservationRepository) {
        this.movieRepository = movieRepository;
        this.cinemaHallrepository = cinemaHallrepository;
        this.showingRepository = showingRepository;
        this.seatRepository = seatRepository;
        this.reservationRepository = reservationRepository;
    }

    public  void makePlainTestData(){


//Movies

Movie m1=  movieRepository.save(new Movie("The Green Man", "Horror", 80, "This is a description", "PG-13", 13));
Movie m2=  movieRepository.save(new Movie("Some Women Dancing", "Comedy", 80, "This is a description", "PG", 7));
Movie m3= movieRepository.save(new Movie("In Captivity", "Thriller", 80, "This is a description", "R", 18));
Movie m4 = movieRepository.save(new Movie("The Love Birds", "Romance", 80, "This is a description", "PG-13", 13));
Movie m5 =movieRepository.save(new Movie("Angry People Watching", "Action", 80, "This is a description", "PG-13", 13));
Movie m6 = movieRepository.save(new Movie("Space Walking", "Science Fiction", 80, "This is a description", "NC-17", 21));

//Halls
        CinemaHall c1 = new CinemaHall(10,10);
        cinemaHallrepository.save(c1);

       CinemaHall c2 = new CinemaHall(45,11);
        cinemaHallrepository.save(c2);

        CinemaHall c3 = new CinemaHall(30,12);
        cinemaHallrepository.save(c3);

        CinemaHall c4 = new CinemaHall(20,10);
        cinemaHallrepository.save(c4);

        CinemaHall c5 = new CinemaHall(40,10);
        cinemaHallrepository.save(c5);

        CinemaHall c6 = new CinemaHall(54,10);
        cinemaHallrepository.save(c6);

        CinemaHall c7 = new CinemaHall(23,10);
        cinemaHallrepository.save(c7);


        //Showings
        //Først skal det opretet showing-objekt gemmes
        Showing sh1 = showingRepository.save(new Showing(LocalDate.of(2022,5,14), LocalTime.of(12,00),90));

        //Her tilføjer en showing til en bestemt hall, hall c1
        c1.addShowing(sh1);

        //Her tilføjer vi en bestemt film til en bestemt showing/visning
        m1.addShowing(sh1);

        /*Herefter skal de nye tilføjelser gemmes.
        For at gemme de nye tilføjelser af film og hal, skal showing gemmes efter de to elementer er tilføjet
        Ellers gemmes de nye tilføjelser ikke til den nyoprettet showing*/
        showingRepository.save(sh1);

        Showing sh2 =showingRepository.save(new Showing(LocalDate.of(2022,9,15), LocalTime.of(3,00),90));
        c2.addShowing(sh2);
        m2.addShowing(sh2);
        showingRepository.save(sh2);

        Showing sh3 = showingRepository.save(new Showing(LocalDate.of(2022,7,13), LocalTime.of(1,00),90));
        c3.addShowing(sh3);
        m3.addShowing(sh3);
        showingRepository.save(sh3);

        Showing sh4 = showingRepository.save(new Showing(LocalDate.of(2022,8,12), LocalTime.of(2,00),90));
        c4.addShowing(sh4);
        m3.addShowing(sh4);
        showingRepository.save(sh4);

        Showing sh5 = showingRepository.save(new Showing(LocalDate.of(2022,3,16), LocalTime.of(2,00),90));
        c5.addShowing(sh5);
        m4.addShowing(sh5);
        showingRepository.save(sh5);

        Showing sh6 = showingRepository.save(new Showing(LocalDate.of(2022,2,17), LocalTime.of(2,00),90));
        c6.addShowing(sh6);
        m6.addShowing(sh6);
        showingRepository.save(sh6);

        //Reservations
        //samme princip som i shwoing, med at gemme to gange gør sig også gældende her i reservation
        Reservation r1= reservationRepository.save(new Reservation());
        sh1.addReservation(r1);
        reservationRepository.save(r1);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Alle deleteAll, gør at hvis tabellerne allerede eksisterer slettes de
        movieRepository.deleteAll();
        cinemaHallrepository.deleteAll();
        showingRepository.deleteAll();
        seatRepository.deleteAll();
        reservationRepository.deleteAll();

        //og herefter oprettes nye tabeller med data fra makePlainTestData-metoden
        makePlainTestData();


    }
}
