package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class AuthService {

    CustomerRepository customerRepository;

    public boolean login(int employee_id, String password) {
        return customerRepository.login(customer_id, password);
    }

    public boolean notLoggedIn(HttpSession session) {
        return session.getAttribute("customer") == null;
    }
}

}
