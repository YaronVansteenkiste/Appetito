package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.DishRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class XDagenMenuController {
    @Autowired
    DishRepository dishRepository;
    @GetMapping("/x-dagenmenu")
    public String xdagenmenu(Model model) {
        Iterable<Dish>allDishes=dishRepository.findAll();
        List<Dish> activeDishes = dishRepository.findByActive(true);
        model.addAttribute("activeDishes",activeDishes);
        model.addAttribute("allDishes",allDishes);

        return "menu";
    }
    @GetMapping("/menuoverview")
    public String showMenuOverview(HttpSession session, Model model) {
        List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");

        // Check if selectedDishes is null and initialize it if necessary
        if (selectedDishes == null) {
            selectedDishes = new ArrayList<>();
            session.setAttribute("selectedDishes", selectedDishes); // Ensure the attribute is set in the session
        }

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

    @PostMapping("/addToMenu")
    public String addToMenu(@RequestParam Integer dishId, HttpSession session) {
        List<Dish> menuItems = (List<Dish>) session.getAttribute("menuItems");
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }

        // Retrieve the dish from the database using the ID
        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        optionalDish.ifPresent(menuItems::add); // Add the dish if present

        session.setAttribute("menuItems", menuItems);
        return "redirect:/menuoverview";
    }

}
