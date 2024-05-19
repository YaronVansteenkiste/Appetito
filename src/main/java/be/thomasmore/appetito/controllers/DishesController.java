package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.DishDto;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import jakarta.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String Home(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Dish> dishesPage = dishRepository.findByActive(true, pageable);
        boolean filterEnabled = false;
        long totalDishes = dishesPage.getTotalElements();
        int totalPages = dishesPage.getTotalPages();
        List<Dish> dishes = dishesPage.getContent();
        model.addAttribute("dishesPage", dishesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("count", totalDishes);
        model.addAttribute("filterEnabled", filterEnabled);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPrevious", dishesPage.hasPrevious());
        model.addAttribute("hasNext", dishesPage.hasNext());
        model.addAttribute("alldishes", dishes);
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
    public String dishesFilter(Model model,
                               @RequestParam(required = false) String dietPreferences,
                               @RequestParam(required = false) String minPreparationTimeStr,
                               @RequestParam(required = false) String maxPreparationTimeStr,
                               @RequestParam(required = false) String preparation,
                               @RequestParam(required = false) String occasion,
                               @RequestParam(required = false) Integer minCarbs,
                               @RequestParam(required = false) Integer maxCarbs,
                               @RequestParam(required = false) Integer minFiber,
                               @RequestParam(required = false) Integer maxFiber,
                               @RequestParam(required = false) Integer minSalt,
                               @RequestParam(required = false) Integer maxSalt,
                               @RequestParam(required = false) Integer minSugar,
                               @RequestParam(required = false) Integer maxSugar,
                               @RequestParam(required = false) Integer minSaturatedFat,
                               @RequestParam(required = false) Integer maxSaturatedFat,
                               @RequestParam(required = false) Integer minFat,
                               @RequestParam(required = false) Integer maxFat,
                               @RequestParam(required = false) Integer minProteins,
                               @RequestParam(required = false) Integer maxProteins,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
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


        int pageSize = size;
        Pageable pageable = PageRequest.of(page, pageSize);
        logger.info("pageable: " + pageable);
        Page<Dish> allDishes = dishRepository.findFilteredDishes(dietPreferences, minPreparationTime, maxPreparationTime,
                occasion, minCarbs, maxCarbs, minFiber,
                maxFiber, minSalt, maxSalt, minSugar, maxSugar,
                minSaturatedFat, maxSaturatedFat, minFat, maxFat,
                minProteins, maxProteins, pageable);



        boolean filterEnabled = true;
        model.addAttribute("dietPreferences", dietPreferenceStr);
        model.addAttribute("minPreparationTime", minPreparationTimeStr);
        model.addAttribute("maxPreparationTime", maxPreparationTimeStr);
        model.addAttribute("occasion", occasionStr);
        model.addAttribute("minCarbs", minCarbs);
        model.addAttribute("maxCarbs", maxCarbs);
        model.addAttribute("minFiber", minFiber);
        model.addAttribute("maxFiber", maxFiber);
        model.addAttribute("minSalt", minSalt);
        model.addAttribute("maxSalt", maxSalt);
        model.addAttribute("minSugar", minSugar);
        model.addAttribute("maxSugar", maxSugar);
        model.addAttribute("minSaturatedFat", minSaturatedFat);
        model.addAttribute("maxSaturatedFat", maxSaturatedFat);
        model.addAttribute("minFat", minFat);
        model.addAttribute("maxFat", maxFat);
        model.addAttribute("minProteins", minProteins);
        model.addAttribute("maxProteins", maxProteins);
        model.addAttribute("count", allDishes.getTotalElements());
        model.addAttribute("alldishes", allDishes);
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("filterEnabled", filterEnabled);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", allDishes.getTotalPages());
        model.addAttribute("hasPrevious", allDishes.hasPrevious());
        model.addAttribute("hasNext", allDishes.hasNext());

        return "dishes";
    }
}