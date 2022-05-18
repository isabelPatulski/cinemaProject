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

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

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



