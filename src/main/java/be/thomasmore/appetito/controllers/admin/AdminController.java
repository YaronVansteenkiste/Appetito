package be.thomasmore.appetito.controllers.admin;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.repositories.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private ChefRepository chefRepository;


    @GetMapping("/")
    public String Dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        Iterable<Chef> chefs = chefRepository.findAll();
        model.addAttribute("chefs", chefs);
        return "admin/users";
    }
}
