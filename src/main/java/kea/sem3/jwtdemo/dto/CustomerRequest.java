package kea.sem3.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private int id;
    private String email;
    private String username;
    //Er birthday en string? eller local date

}

