package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Rating;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.RatingRepository;
import be.thomasmore.appetito.services.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.security.Principal;
import java.time.LocalTime;
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
    public String Home(Model model, Principal principal, @RequestParam(name = "occasion", required = false) String occasion) {
        final String loginName = principal != null ? principal.getName() : "";

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

        LocalTime now = LocalTime.now();
        String message;
        int hour = now.getHour();
        String suggestion = "";


        if (hour < 5){
            message = "Goedenacht";
            suggestion = "Er zijn momenteel geen suggesties";
        }
        else if (hour < 12){
            message = "Goedemorgen";
            suggestion = "Hier is een suggestie van de lekkerste ontbijten";
            occasion = "ontbijt";
        }
        else if (hour < 17){
            message = "Goedemiddag";
            suggestion = "Hier is een suggestie van de lekkerste middagmalen";
            occasion = "middagmaal";

        }
        else {
            message = "Goedeavond";
            suggestion = "Hier is een suggestie van de lekkerste avondmalen";
            occasion = "avondmaal";

        }
        if (loginName != null && !loginName.isEmpty()) {
            message += ", " +loginName;
        } else {
            message += "";
        }

        List <Dish> dishes = dishRepository.findByOccasion(occasion, PageRequest.of(0,3));
        model.addAttribute("message",message);
        model.addAttribute("dishes",dishes);
        model.addAttribute("suggestion",suggestion);
        model.addAttribute("loginName", loginName);
        model.addAttribute("topRatedDish", topRatedDish);
        model.addAttribute("topRatedDishAverageRating", topRatedDishAverageRating);
        return "home";
    }


}
