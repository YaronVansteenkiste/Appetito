package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Rating;

import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Controller
public class RatingController {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping("/dishdetails/addratings/{id}")
    public String addRating(@PathVariable Integer id, @RequestParam int rating) {


        Optional<Dish> dishOptional = dishRepository.findById(id);

        if (dishOptional.isPresent()) {
            Dish dish = dishOptional.get();
            Rating newRating = new Rating();
            newRating.setRating(rating);
            newRating.setDish(dish);
            ratingRepository.save(newRating);

        }

        return "redirect:/dishdetails/" + id;
    }

}