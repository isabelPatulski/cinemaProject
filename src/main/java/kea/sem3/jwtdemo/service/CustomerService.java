package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> new CustomerResponse(customer,false)).collect(Collectors.toList());
    }

    public CustomerResponse getCustomerByUserName(String username) {
        Customer customer = customerRepository.findById(username).orElseThrow(() -> new Client4xxException("User not found", HttpStatus.NOT_FOUND));
        return new CustomerResponse(customer,false);
    }
    }
    public CustomerResponse getCustomer(int id) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new Client4xxException("No customer with this id exists"));
        return new CustomerResponse(customer);
    }
    public CustomerResponse addMember(CustomerRequest body) {

        if (customerRepository.existsById((body.getUsername()))) {
            throw new Client4xxException("Provided user name is taken");
        }
        if (customerRepository.emailExist(body.getEmail())) {
            throw new Client4xxException("Provided email is taken");
        }
        Customer customer = new Customer(body);
        customer = customerRepository.save(customer);
        return new CustomerResponse(customer.getUsername(), customer.getEmail());
    }

    public CustomerResponse editCustomer(CustomerRequest customerToEdit, int customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new Client4xxException("No customer with provided ID found"));
        customer.setUsername(customerToEdit.getUsername());
        customer.setEmail(customerToEdit.getEmail());
        return new CustomerResponse(customerRepository.save(customer));
    }



    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}

