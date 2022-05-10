package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> getCustomers(){
        List<Customer> customers =  customerRepository.findAll();
        return CustomerResponse.getCustomersFromEntities(customers);
    }
    public CustomerResponse getCustomer(int id) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new Client4xxException("No customer with this id exists"));
        return new CustomerResponse(customer);
    }
    public CustomerResponse addCustomer(CustomerRequest body){
        Customer newCustomer = customerRepository.save(new Customer(body));
        return new CustomerResponse(newCustomer);
    }
    public CustomerResponse editCustomer(CustomerRequest customerToEdit, int customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new Client4xxException("No customer with provided ID found"));
        customer.setUsername(customerToEdit.getUsername());
        customer.setEmail(customerToEdit.getEmail());
        return new CustomerResponse(customerRepository.save(customer));
    }

    //PATCH method for Username
    public void updateUsername(int customerId, String newUsername){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new Client4xxException("No customer with provided ID found"));
        customer.setUsername(newUsername);
        customerRepository.save(customer);
    }

    //PATCH for Email
    public void updateEmail(int customerId,String newEmail){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new Client4xxException("No customer with provided ID found"));
        customer.setEmail(newEmail);
        customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}

