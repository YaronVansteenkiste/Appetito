package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.DishDto;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import jakarta.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class DishesController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    IngredientRepository ingredientRepository;
   private Logger logger = Logger.getLogger(DishesController.class.getName());




    @GetMapping("/dishes")
    public String Home(Model model) {
        boolean filterEnabled = false;
        Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> activeDishes = dishRepository.findByActiveTrue();
        model.addAttribute("dishes",activeDishes);
        model.addAttribute("count", allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes", allDishes);
        model.addAttribute("filterEnabled", filterEnabled);
        return "dishes";
    }


    @GetMapping("/dishes/search")
    public String search(Model model, @RequestParam String keyword) {
        logger.info("searching for: " + keyword);
        Iterable<Dish> allDishes = dishRepository.findByName("%" + keyword + "%");
        model.addAttribute("count", allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes", allDishes);
        return "dishes";
    }

    @GetMapping("/dishes/filter")
    public String dishesFilter(Model model, @RequestParam(required = false) String dietPreferences,
                               @RequestParam(required = false) String minPreparationTimeStr,
                               @RequestParam(required = false) String maxPreparationTimeStr,
                               @RequestParam(required = false) String preparation,
                               @RequestParam(required = false) String occasion,
                               @RequestParam(required = false) Integer minCarbs,
                               @RequestParam(required = false) Integer maxCarbs) {
        Iterable<Dish> allDishes = dishRepository.findAll();
        String dietPreferenceStr = "";
        String occasionStr = "";
        if (dietPreferences != null) {
            dietPreferenceStr = dietPreferences;
        }
        if (occasion != null) {
            occasionStr = occasion;
        }

        Time minPreparationTime = null;
        Time maxPreparationTime = null;

        if (minPreparationTimeStr != null) {
            if (!minPreparationTimeStr.isEmpty()) {
                minPreparationTime = Time.valueOf(minPreparationTimeStr);
            }
        }

        if (maxPreparationTimeStr != null) {
            if (!maxPreparationTimeStr.isEmpty()) {
                maxPreparationTime = Time.valueOf(maxPreparationTimeStr);
            }
        }

        boolean filterEnabled = true;
        allDishes = dishRepository.findFilteredDishes(dietPreferences, minPreparationTime, maxPreparationTime, preparation, occasion, minCarbs, maxCarbs);
        model.addAttribute("dietPreferences", dietPreferenceStr);
        model.addAttribute("minPreparationTime", minPreparationTimeStr);
        model.addAttribute("maxPreparationTime", maxPreparationTimeStr);
        model.addAttribute("preparation", preparation);
        model.addAttribute("occasion", occasionStr);
        model.addAttribute("minCarbs", minCarbs);
        model.addAttribute("maxCarbs", maxCarbs);
        model.addAttribute("count", allDishes.spliterator().estimateSize());
        model.addAttribute("alldishes", allDishes);
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("filterEnabled", filterEnabled);
        return "dishes";
    }

}