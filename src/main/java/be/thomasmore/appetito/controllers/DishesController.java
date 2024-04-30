package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishesController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @GetMapping("/dishes")
    public String Home(Model model) {

        Iterable<Dish>allDishes= dishRepository.findAll();
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);

        return "dishes";
    }


    @GetMapping("/dishes/search")
    public String search(Model model, String search) {
        Iterable<Dish> dishes = dishRepository.findByName(search);
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dishes/filter")
    public String filter(Model model, String dietPreferences, Integer preparationTime, String preparation, String occasion) {
        Iterable<Dish> dishes = dishRepository.findFilteredDishes(dietPreferences, preparationTime, preparation, occasion);
        model.addAttribute("dishes", dishes);
        return "dishes";
    }
}