package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.*;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.GroceryRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class DishDetailController<ToggleRequest> {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private GroceryRepository groceryRepository;

    @GetMapping({"/dishdetails/{id}", "/dishdetails"})
    public String dishDetail(Model model, @PathVariable(required = false) Integer id) {
        final Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> allTheDishes = dishRepository.findAllByOrderByIdAsc();
        model.addAttribute("dishes", allDishes);
        model.addAttribute("allDishes", allTheDishes);
        model.addAttribute("isActive", allTheDishes.get(id - 1).isActive());


        if (id == null) {
            return "error";
        }

        Optional<Dish> dishFromDB = dishRepository.findById(id);
        Collection<Beverage> beverages = dishFromDB.get().getBeverages();
        model.addAttribute("beverages", beverages);

        dishFromDB.ifPresent(dish -> {
            model.addAttribute("dish", dish);
            model.addAttribute("currentDish", dish.getId());

        });

        if (dishFromDB.isPresent()) {
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
            model.addAttribute("firstDish", firstDish.get().getId());
            model.addAttribute("lastDish", lastDish.get().getId());
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


    @PostMapping("/dishdetails/addingredients/{id}")
    public String addIngredientsToGrocery(@PathVariable(required = true) Integer id, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Optional<Dish> dishFromDB = dishRepository.findById(id);
        Dish dish = dishFromDB.get();

        Collection<Ingredient> ingredients = dish.getIngredients();

        Chef chef = chefRepository.findByUsername(principal.getName());
        Optional<Grocery> groceryFromDB = groceryRepository.findById(chefRepository.findByUsername(principal.getName()).getId());
        if (groceryFromDB.isPresent()) {
            Grocery grocery = groceryFromDB.get();
            Collection<Ingredient> groceryIngredients = grocery.getIngredients();
            for (Ingredient ingredient : ingredients) {
                if (!groceryIngredients.contains(ingredient)) {
                    groceryIngredients.add(ingredient);
                }
            }
            grocery.setIngredients(groceryIngredients);
            groceryRepository.save(grocery);

        } else {
            Grocery grocery = new Grocery();
            grocery.setChef(chef);
            Collection<Ingredient> newIngredients = new ArrayList<>(ingredients);
            grocery.setIngredients(newIngredients);
            groceryRepository.save(grocery);
        }
        return "redirect:/groceries/";
    }

}
