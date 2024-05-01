package be.thomasmore.appetito.controllers.admin;


import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@RequestMapping("/admin")
@Controller
public class DishAdminController {

    @Autowired
    DishRepository dishRepository;

    @GetMapping("/dishedit/{id}")
    public String dishEdit(Model model, @PathVariable(required = false) Integer id){
        Optional<Dish> dishFromDB = dishRepository.findById(id);
        dishFromDB.ifPresent(dish -> model.addAttribute("dish", dish));

        return "admin/dishedit";
    }
}
