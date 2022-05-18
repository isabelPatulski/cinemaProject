package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Showing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private String genre;
    private String description;
    private int price;
    private int ageLimit;
    private String rating;
    private Set<Showing> showings;
}
