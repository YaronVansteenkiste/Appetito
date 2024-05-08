package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class DishDetailController<ToggleRequest> {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping({"/dishdetails/{id}" , "/dishdetails"})
    public String dishDetail(Model model, @PathVariable(required = false) Integer id){
        final Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> allTheDishes = dishRepository.findAllByOrderByIdAsc();
        model.addAttribute("dishes", allDishes);
        model.addAttribute("allDishes",allTheDishes);
        model.addAttribute("isActive",allTheDishes.get(id).isActive());


        if(id == null){
            return "error";
        }

        Optional<Dish> dishFromDB = dishRepository.findById(id);

        dishFromDB.ifPresent(dish -> {
            model.addAttribute("dish", dish);
            model.addAttribute("currentDish", dish.getId());

        });

        if(dishFromDB.isPresent())
        {
            model.addAttribute("dish", dishFromDB.get());
            Optional<Dish> previousDish = dishRepository.findFirstByIdLessThanOrderByIdDesc(id);
            Optional<Dish> firstDish = dishRepository.findFirstByOrderByIdAsc();
            if (previousDish.isEmpty())
                previousDish = dishRepository.findFirstByOrderByIdDesc();
            Optional<Dish> nextDish = dishRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            Optional<Dish> lastDish = dishRepository.findFirstByOrderByIdDesc();
            if (nextDish.isEmpty())
                nextDish = dishRepository.findFirstByOrderByIdAsc();
            model.addAttribute("previousDish", previousDish.get().getId());
            model.addAttribute("nextDish", nextDish.get().getId());
            model.addAttribute("firstDish",firstDish.get().getId());
            model.addAttribute("lastDish",lastDish.get().getId());
        }
        return "dishdetail";
    }

    @PostMapping("/toggle/dish/{id}")
    public String updateDishToggleState(@PathVariable("id") int id, @RequestParam boolean active) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new IllegalStateException("Dish not found"));
        dish.setActive(active);
        dishRepository.save(dish);
        return "redirect:/dishdetails/" + id;
    }

}
