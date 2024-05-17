package be.thomasmore.appetito.controllers.admin;

import be.thomasmore.appetito.model.Beverage;
import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.BeverageRepository;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private BeverageRepository beverageRepository;



    @GetMapping("/")
    public String Dashboard(Model model) {
        Iterable<Dish> dishes = dishRepository.findAll();
        model.addAttribute("dishes", dishes);
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        Iterable<Chef> chefs = chefRepository.findAll();
        model.addAttribute("chefs", chefs);
        return "admin/users";
    }

    @PostMapping("/toggle/dish/{id}")
    public String updateDishToggleState(@PathVariable("id") int id, @RequestParam boolean active) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new IllegalStateException("Dish not found"));
        dish.setActive(active);
        dishRepository.save(dish);
        return "redirect:/";
    }

    @PostMapping("/toggle/beverage/{id}")
    public String updateBeverageToggleState(@PathVariable("id") int id, @RequestParam boolean active){
        Beverage beverage = beverageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Beverage not found"));
        beverage.setActive(active);
        beverageRepository.save(beverage);
        return "redirect:/dishdetails/" + id;
    }
}
