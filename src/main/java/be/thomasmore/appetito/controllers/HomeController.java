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
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private GoogleService googleService;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private ChefRepository chefRepository;

    @GetMapping("/")
    public String Home(Model model, Principal principal, @RequestParam(name = "occasion", required = false) String occasion) {
        final String loginName = principal != null ? principal.getName() : "";

        List<Dish> topRatedDishes = dishRepository.findTopDishes();

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
        Chef chef = chefRepository.findByUsername(loginName);

        if (chef != null) {
            PageRequest pageRequest = PageRequest.of(0, 6);
            List<Dish> dishes = dishRepository.findByChefAndConceptDishFalse(chef, pageRequest);


            model.addAttribute("allDishes",dishes);

        } else {
            model.addAttribute("allDishes", List.of());
        }

        List <Dish> dishes = dishRepository.findRandomDishesByOccasion(occasion);

        model.addAttribute("message",message);
        model.addAttribute("dishes",dishes);
        model.addAttribute("suggestion",suggestion);
        model.addAttribute("loginName", loginName);
        model.addAttribute("topRatedDishes", topRatedDishes);


        return "home";
    }


}
