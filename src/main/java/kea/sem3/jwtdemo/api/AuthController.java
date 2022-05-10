package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.service.AuthService;
import kea.sem3.jwtdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("auth")
public class AuthController {

    CustomerService customerService;
    AuthService authService;

    @GetMapping("/")
    public String login(HttpSession session) {
        if (authService.notLoggedIn(session)) {
            return "index";
        }
        return "frontPage";
    }

    @PostMapping("/login")
    public String login(WebRequest wr, HttpSession session) throws SQLException {
        int customerId = Integer.parseInt(wr.getParameter("customer_id"));
        String password = wr.getParameter("password");

        //Evaluer om login-oplysninger matcher database
        if (authService.login(customerId, password)) {
            //Hvis if-statement == true
            //Hent employee fra database
            Customer customer = customerService.showEmployee(customerId);
            //Sæt employee som attribut til sessionen
            session.setAttribute("customer", customer);
            return "redirect:/frontPage";
        }
        return "/index";
    }

    @GetMapping("/frontpage")
    public String customer(HttpSession session) {
        if (authService.notLoggedIn(session)) {
            return "redirect:/";
        } else {
            return "frontPage";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        //Afslutter den nuværende session
        session.invalidate();
        return "redirect:/";
    }

}
