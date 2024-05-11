package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Beverage;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.BeverageRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class DishDetailController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping({"/dishdetails/{id}" , "/dishdetails"})
    public String dishDetail(Model model, @PathVariable(required = false) Integer id){
        final Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> allTheDishes = dishRepository.findAllByOrderByIdAsc();
        model.addAttribute("dishes", allDishes);
        model.addAttribute("allDishes",allTheDishes);


        if(id == null){
            return "error2";
        }

        Optional<Dish> dishFromDB = dishRepository.findById(id);
        Collection<Beverage> beverages = dishFromDB.get().getBeverages();
        model.addAttribute("beverages", beverages);

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

}
