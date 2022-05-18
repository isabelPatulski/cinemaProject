package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.MovieResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import kea.sem3.jwtdemo.service.CustomerService;
import kea.sem3.jwtdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    /*public Customer registerUser(@Valid @RequestBody Customer newCustomer) {
        List<Customer> getCustomers = customerRepository.findAll();
        System.out.println("New user: " + newCustomer.toString());
        for (Customer customer : getCustomers) {
            System.out.println("Registered user: " + newCustomer.toString());
            if (customer.equals(newCustomer)) {
                System.out.println("User Already exists!");
            }
        }
        customerRepository.save(newCustomer);
        return newCustomer;
    }*/

    @GetMapping
    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable int id) throws Exception {
        return customerService.getCustomer(id);
    }

    @PostMapping()
    public CustomerResponse addCustomer(@RequestBody CustomerRequest body) {
        return customerService.addCustomer(body);
    }

    @PutMapping("/{id}")
    public CustomerResponse editCustomer(@RequestBody CustomerRequest body, @PathVariable int id) {
        return customerService.editCustomer(body, id);
    }


}



