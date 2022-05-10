package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    int id;

    String username;
    String email;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime updated;

    public CustomerResponse(Customer customer) {
        this.username = customer.getUsername();
        this.email = customer.getEmail();

    }

    public static List<kea.sem3.jwtdemo.dto.CustomerResponse> getCustomersFromEntities(List<Customer> customers){
        return customers.stream().map(customer-> new kea.sem3.jwtdemo.dto.CustomerResponse(customer)).collect(Collectors.toList());
    }
}

