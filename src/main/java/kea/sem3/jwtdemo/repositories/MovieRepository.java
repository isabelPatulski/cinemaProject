package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}