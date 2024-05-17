package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Rating;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.RatingRepository;
import be.thomasmore.appetito.services.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private GoogleService googleService;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/")
    public String Home(Model model, Principal principal) {
        final String loginName = principal != null ? principal.getName() : "anoniem";

        List<Dish> allDishes = (List<Dish>) dishRepository.findAll();
        Optional<Dish> topRatedDishOptional = allDishes.stream()
                .filter(dish -> dish.getRatings() != null && !dish.getRatings().isEmpty())
                .max(Comparator.comparingDouble(dish -> dish.getRatings().stream()
                        .mapToInt(Rating::getRating)
                        .average()
                        .orElse(0)));


        Dish topRatedDish = topRatedDishOptional.orElse(null);
        Double topRatedDishAverageRating = topRatedDish != null
                ? topRatedDish.getRatings().stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0)
                : null;

        model.addAttribute("loginName", loginName);
        model.addAttribute("topRatedDish", topRatedDish);
        model.addAttribute("topRatedDishAverageRating", topRatedDishAverageRating);
        return "home";
    }


}
