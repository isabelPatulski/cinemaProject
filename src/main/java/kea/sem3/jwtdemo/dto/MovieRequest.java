package kea.sem3.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
