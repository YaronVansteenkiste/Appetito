package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishesRepository;
import be.thomasmore.appetito.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DishesController {
    @Autowired
    DishesRepository dishesRepository;
    @Autowired
    IngredientsRepository ingredientsRepository;
    @GetMapping("/dishes")
    public String Home(Model model) {

        Iterable<Dish>allDishes= dishesRepository.findAll();
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);

        return "dishes";
    }


    @GetMapping("/dishes/filter")
    public String dishesFilter(Model model, @RequestParam(required = false) String dietPreferences,
                               @RequestParam(required = false) Integer preparationTime,
                               @RequestParam(required = false) String preparation,
                               @RequestParam(required = false) String occasion) {
        Iterable<Dish>allDishes= dishesRepository.findAll();
        allDishes = dishesRepository.findFilteredDishes(dietPreferences,preparationTime,preparation,occasion);
        model.addAttribute("dietPreferences",dietPreferences);
        model.addAttribute("preparationTime",preparationTime);
        model.addAttribute("preparation",preparation);
        model.addAttribute("occasion",occasion);
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);
        model.addAttribute("allIngredients",ingredientsRepository.findAll());
        return "dishes";
    }
}