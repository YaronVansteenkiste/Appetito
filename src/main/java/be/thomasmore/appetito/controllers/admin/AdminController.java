package be.thomasmore.appetito.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@Controller
public class AdminController {


    @GetMapping("/")
    public String Dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users() {
        return "admin/users";
    }
}
