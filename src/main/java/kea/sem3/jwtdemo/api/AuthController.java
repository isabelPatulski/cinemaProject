package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import kea.sem3.jwtdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("auth")
public class AuthController {

    CustomerRepository customerRepository;
    CustomerService customerService;



}
   /* @PostMapping("/customers/login")
    public Customer loginCustomer(@Valid @RequestBody Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer other : customers) {
            if (other.equals(customer)) {
                customer.setLoggedIn(true);
                customerRepository.save(customer);
            }
        }
        return customer;
    }
    @PostMapping("/customers/logout")
    public Customer logOut(@Valid @RequestBody Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer other : customers) {
            if (other.equals(customer)) {
                customer.setLoggedIn(false);
                customerRepository.save(customer);
                return customer;
            }
        }
        return customer;
    }

    @PutMapping("/{id}")
    public CustomerResponse editCustomer(@RequestBody CustomerRequest body, @PathVariable int id){
        return customerService.editCustomer(body,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){}



}



