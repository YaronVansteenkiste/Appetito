package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class XDagenMenuController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ChefRepository chefRepository;

    @GetMapping("/x-dagenmenu")
    public String xdagenmenu(Model model) {
        Iterable<Dish> allDishes = dishRepository.findAll();
        List<Dish> activeDishes = dishRepository.findByActive(true);
        model.addAttribute("activeDishes", activeDishes);
        model.addAttribute("allDishes", allDishes);

        return "menu";
    }

    @GetMapping("/menuoverview")
    public String showMenuOverview(HttpSession session, Model model) {

        List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");
        model.addAttribute("selectedDishes", selectedDishes);
        model.addAttribute("count", selectedDishes.size());

        return "menuoverview";
    }

    @PostMapping("/dishes/select")
    public String selectDishes(@RequestParam("selectedDishes") List<Integer> dishIds, HttpSession session) {
        List<Dish> selectedDishes = new ArrayList<>();

        for (Integer dishId : dishIds) {
            Dish selectedDish = dishRepository.findById(dishId).orElse(null);
            if (selectedDish != null) {
                selectedDishes.add(selectedDish);
            }
        }

        session.setAttribute("selectedDishes", selectedDishes);

        return "redirect:/menuoverview";
    }

    @PostMapping("/dishdetails/{id}")
    public String selectDish(Model model, @RequestParam("dishId") Integer dishId, HttpSession session, Principal principal) {

        Chef chef = null;
        if (principal != null) {
            chef = chefRepository.findByUsername(principal.getName());
        }

        Dish selectedDish = dishRepository.findById(dishId).orElseThrow(() -> new IllegalStateException("Dish not found"));

        if (chef != null) {

            chef.addDish(selectedDish);
            chefRepository.save(chef);
        } else {

            List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");
            if (selectedDishes == null) {
                selectedDishes = new ArrayList<>();
            }
            selectedDishes.add(selectedDish);
            session.setAttribute("selectedDishes", selectedDishes);
        }

        model.addAttribute("dish", selectedDish);
        return "redirect:/dishdetails/" + dishId;
    }



}
