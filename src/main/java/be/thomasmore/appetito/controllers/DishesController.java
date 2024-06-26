package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.DishDto;
import be.thomasmore.appetito.model.Rating;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import jakarta.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.PrincipalMethodArgumentResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class DishesController {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    private Logger logger = Logger.getLogger(DishesController.class.getName());


    @GetMapping("/dishes")
    public String Home(Model model, @RequestParam(defaultValue = "0") int page, Principal principal,
                       String filter) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"));

        List<Dish> allTheDishes;
        if (isAdmin) {
            allTheDishes = dishRepository.findAll();
        } else {
            allTheDishes = dishRepository.findByActiveTrue();
        }

        List<Dish> diets;
        if ("Andere".equals(filter)) {
            diets = dishRepository.findByCustomDietPreferencesIsNotNull();
        } else {
            diets = dishRepository.findAll();
        }
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
        model.addAttribute("allTheDishes", allTheDishes);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("diets", diets);
        return "dishes";

    }


    @GetMapping("/dishes/search")
    public String search(Model model, @RequestParam String keyword) {
        logger.info("searching for: " + keyword);
        List<String> keywords = Arrays.asList(keyword.split(",")).stream().map(String::trim).collect(Collectors.toList());
        Set<Dish> allDishes = new HashSet<>();
        for (String key : keywords) {
            Iterable<Dish> dishes = dishRepository.findByNameOrIngredients(key);
            dishes.forEach(allDishes::add);
        }
        model.addAttribute("count", allDishes.size());
        model.addAttribute("alldishes", allDishes);
        model.addAttribute("keyword", keyword);

        return "dishes";
    }

    @GetMapping("/dishes/filter")
    public String dishesFilter(Model model,
                               @RequestParam(required = false) String dietPreferencesStr,
                               @RequestParam(required = false) String customDietPreferences,
                               @RequestParam(required = false) String minPreparationTimeStr,
                               @RequestParam(required = false) String maxPreparationTimeStr,
                               @RequestParam(required = false) String occasionStr,
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
                               @RequestParam(required = false) String ratingStr,
                               @RequestParam(defaultValue = "0") int page) {
        List<String> dietPreferences = null;
        if (dietPreferencesStr != null && !dietPreferencesStr.isEmpty()) {
            dietPreferences = Arrays.asList(dietPreferencesStr.split(","));
        }
        List<String> occasion = null;
        if (occasionStr != null && !occasionStr.isEmpty()) {
            occasion = Arrays.asList(occasionStr.split(","));
        }

        Time minPreparationTime = null;
        Time maxPreparationTime = null;

        if (minPreparationTimeStr != null && !minPreparationTimeStr.isEmpty()) {
            if (minPreparationTimeStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
                minPreparationTime = Time.valueOf(minPreparationTimeStr);
            }
        }
        if (maxPreparationTimeStr != null && !maxPreparationTimeStr.isEmpty()) {
            if (maxPreparationTimeStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
                maxPreparationTime = Time.valueOf(maxPreparationTimeStr);
            }
        }
        List<String> customDietPreferencesList = dishRepository.findDistinctCustomDietPreferences();

        List<Integer> ratings = null;
        if (ratingStr != null && !ratingStr.isEmpty()) {
            ratings = switch (ratingStr) {
                case "5" -> List.of(5);
                case "4" -> List.of(4);
                case "3" -> List.of(3);
                case "2" -> List.of(2);
                case "1" -> List.of(1);
                default -> Arrays.stream(ratingStr.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            };
        }
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        logger.info("pageable: " + pageable);
        Page<Dish> allDishes = dishRepository.findFilteredDishes(dietPreferences, customDietPreferences, minPreparationTime, maxPreparationTime,
                occasion, minCarbs, maxCarbs, minFiber,
                maxFiber, minSalt, maxSalt, minSugar, maxSugar,
                minSaturatedFat, maxSaturatedFat, minFat, maxFat,
                minProteins, maxProteins, ratings, pageable);

        boolean filterEnabled = true;
        model.addAttribute("dietPreferences", dietPreferences);
        model.addAttribute("customDietPreferences", customDietPreferences);
        model.addAttribute("minPreparationTime", minPreparationTimeStr);
        model.addAttribute("maxPreparationTime", maxPreparationTimeStr);
        model.addAttribute("occasion", occasion);
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
        model.addAttribute("ratings", ratings);
        model.addAttribute("count", allDishes.getTotalElements());
        model.addAttribute("alldishes", allDishes.getContent());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("filterEnabled", filterEnabled);
        model.addAttribute("customDietPreferencesList", customDietPreferencesList);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", allDishes.getTotalPages());
        model.addAttribute("hasPrevious", allDishes.hasPrevious());
        model.addAttribute("hasNext", allDishes.hasNext());

        return "dishes";
    }

    @PostMapping("/add-favorite")
    public String addFavorite(@RequestBody Map<String, String> body) {
        logger.info("body: " + body);
        Integer favoriteDishesId = Integer.parseInt(body.get("favoriteDishesId"));
        Integer chefId = Integer.parseInt(body.get("chefId"));
        String action = body.get("action");
        Optional<Dish> optionalDish = dishRepository.findById(favoriteDishesId);
        Optional<Chef> optionalChef = chefRepository.findById(chefId);
        if (optionalDish.isPresent() && optionalChef.isPresent()) {
            Dish dish = optionalDish.get();
            Chef chef = optionalChef.get();
            if (action.equals("add")) {
                chef.getFavoriteDishes().add(dish);
            } else if (action.equals("remove")) {
                chef.getFavoriteDishes().remove(dish);
            }
            chefRepository.save(chef);
        }
        return "redirect:/dishes";
    }
}