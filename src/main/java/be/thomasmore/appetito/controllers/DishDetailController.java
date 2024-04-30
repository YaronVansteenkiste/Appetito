package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;

@Controller
public class DishDetailController {

    @Autowired
    private DishesRepository dishesRepository;

    @GetMapping({"/dishdetails/{id}" , "/dishdetails"})
    public String dishDetail(Model model, @PathVariable(required = false) Integer id){
        final Iterable<Dish> allDishes = dishesRepository.findAll();
        model.addAttribute("dishes", allDishes);

        if(id == null){
            return "error";
        }

        Optional<Dish> dishFromDB = dishesRepository.findById(id);
        if(dishFromDB.isPresent())
        {
            model.addAttribute("dish", dishFromDB.get());
        }
        return "dishdetail";
    }
}
