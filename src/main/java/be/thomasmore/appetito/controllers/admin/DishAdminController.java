package be.thomasmore.appetito.controllers.admin;


import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/admin")
@Controller
public class DishAdminController {

    @Autowired
    DishRepository dishRepository;

    @ModelAttribute("dish")
    public Dish findDish(@PathVariable(required = false) Integer id){
        Optional<Dish> dishFromDB = dishRepository.findById(id);
        return dishFromDB.orElseGet(Dish::new);
    }


    @GetMapping("/dishedit/{id}")
    public String dishEdit(Model model, @PathVariable(required = false) Integer id){
        return "admin/dishedit";
    }

    @PostMapping("/dishedit/{id}")
    public String dishEditPost(@ModelAttribute("dish") Dish dish){
        dishRepository.save(dish);
        return "redirect:/dishdetails/" + dish.getId();
    }
}
