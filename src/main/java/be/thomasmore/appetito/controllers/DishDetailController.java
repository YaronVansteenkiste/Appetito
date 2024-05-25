package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.*;
import be.thomasmore.appetito.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import be.thomasmore.appetito.model.Beverage;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;

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
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private StepRepository stepRepository;

    @Autowired
    private BeverageRepository beverageRepository;

    @GetMapping({"/dishdetails/{id}", "/dishdetails"})
    public String dishDetail(Model model, @PathVariable(required = false) Integer id, Authentication authentication) {
        final Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> allTheDishes = dishRepository.findAllByOrderByIdAsc();
        model.addAttribute("dishes", allDishes);
        model.addAttribute("allDishes", allTheDishes);
        model.addAttribute("isActive", allTheDishes.get(id - 1).isActive());


        if (id == null) {
            return "error";
        }

        final Iterable<Step> steps = stepRepository.findByDishId(id);

        model.addAttribute("steps", steps);

        Optional<Dish> dishFromDB = dishRepository.findById(id);
        Collection<Beverage> beverages = dishFromDB.get().getBeverages();
        model.addAttribute("beverages", beverages);

        dishFromDB.ifPresent(dish -> {
            model.addAttribute("dish", dish);
            model.addAttribute("currentDish", dish.getId());

        });

        if (dishFromDB.isPresent()) {
            Dish dish = dishFromDB.get();
            boolean isAuthenticated = authentication != null && authentication.isAuthenticated();
            boolean isAdmin = isAuthenticated && authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
            model.addAttribute("isAdmin", isAdmin);
            if (!dish.isActive() && !isAdmin) {
                return "redirect:/error";
            }
            model.addAttribute("dish",dish);
            return "dishdetail";
        }

        if (dishFromDB.get().isActive()) {
            model.addAttribute("dish", dishFromDB.get());
            Optional<Dish> previousDish = dishRepository.findFirstByIdLessThanAndActiveOrderByIdDesc(id,true);
            Optional<Dish> firstDish = dishRepository.findFirstByActiveOrderByIdAsc(true);
            if (previousDish.isEmpty())
                previousDish = dishRepository.findFirstByActiveOrderByIdDesc(true);
            Optional<Dish> nextDish = dishRepository.findFirstByIdGreaterThanAndActiveOrderByIdAsc(id,true);
            Optional<Dish> lastDish = dishRepository.findFirstByActiveOrderByIdDesc(true);
            if (nextDish.isEmpty())
                nextDish = dishRepository.findFirstByActiveOrderByIdAsc(true);
            previousDish.ifPresent(dish -> model.addAttribute("previousDish", dish.getId()));
            nextDish.ifPresent(dish -> model.addAttribute("nextDish", dish.getId()));
            firstDish.ifPresent(dish -> model.addAttribute("firstDish", dish.getId()));
            lastDish.ifPresent(dish -> model.addAttribute("lastDish", dish.getId()));
        }

        Optional<Dish> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()) {
            Dish dish = optionalDish.get();
            double averageRating = calculateAverageRating(dish);
            model.addAttribute("dish", dish);
            model.addAttribute("averageRating", averageRating);
        } else {
            return "error";
        }
        return "dishdetail";
    }
    private double calculateAverageRating(Dish dish) {
        List<Rating> ratings = dish.getRatings();
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        return ratings.stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0.0);
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

    @PostMapping("/toggle/beverage/{id}")
    public String updateBeverageToggleState(@PathVariable("id") int id, @RequestParam boolean active) {
        Beverage beverage = beverageRepository.findById(id).orElseThrow(() -> new IllegalStateException("Beverage not found"));
        beverage.setActive(active);
        beverageRepository.save(beverage);

        int dishId = beverage.getDishes().iterator().next().getId();
        return "redirect:/dishdetails/" + dishId;
    }

}
