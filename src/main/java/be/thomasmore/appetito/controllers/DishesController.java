package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dishes;
import be.thomasmore.appetito.repositories.DishesRepository;
import be.thomasmore.appetito.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishesController {
    @Autowired
    DishesRepository dishesRepository;
    @Autowired
    IngredientsRepository ingredientsRepository;
    @GetMapping("/dishes")
    public String Home(Model model) {

        Iterable<Dishes>allDishes= dishesRepository.findAll();
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);

        return "dishes";
    }


    @GetMapping("/dishes/filter")
    public String dishesFilter(Model model) {
        Iterable<Dishes>allDishes= dishesRepository.findAll();
        model.addAttribute("count",allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes",allDishes);
        model.addAttribute("allIngredients",ingredientsRepository.findAll());
        return "dishesFilter";
    }
}