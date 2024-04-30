package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DishesController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @GetMapping("/dishes")
    public String Home(Model model) {
        boolean filterEnabled = false;
        Iterable<Dish>allDishes= dishRepository.findAll();
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);
        model.addAttribute("filterEnabled",filterEnabled);
        return "dishes";
    }


    @GetMapping("/dishes/search")
    public String search(Model model, String search) {
        Iterable<Dish> dishes = dishRepository.findByName(search);
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dishes/filter")
    public String dishesFilter(Model model, @RequestParam(required = false) String dietPreferences,
                               @RequestParam(required = false) String minPreparationTime,
                                 @RequestParam(required = false) String maxPreparationTime,
                               @RequestParam(required = false) String preparation,
                               @RequestParam(required = false) String occasion) {
        Iterable<Dish>allDishes= dishRepository.findAll();
        boolean filterEnabled=  true;
        allDishes = dishRepository.findFilteredDishes(dietPreferences,minPreparationTime, maxPreparationTime,preparation,occasion);
        model.addAttribute("dietPreferences",dietPreferences);
        model.addAttribute("minPreparationTime",minPreparationTime);
        model.addAttribute("maxPreparationTime",maxPreparationTime);
        model.addAttribute("preparation",preparation);
        model.addAttribute("occasion",occasion);
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);
        model.addAttribute("allIngredients",ingredientRepository.findAll());
        model.addAttribute("filterEnabled",filterEnabled);
        return "dishes";
    }


}