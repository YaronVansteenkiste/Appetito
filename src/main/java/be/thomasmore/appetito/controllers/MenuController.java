package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Menu;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.MenuRepository;
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


@Controller
public class MenuController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ChefRepository chefRepository;
    @Autowired
    MenuRepository menuRepository;

//    @GetMapping("/x-dagenmenu")
//    public String xdagenmenu(Model model) {
//        Iterable<Dish> allDishes = dishRepository.findAll();
//        List<Dish> activeDishes = dishRepository.findByActive(true);
//        model.addAttribute("activeDishes", activeDishes);
//        model.addAttribute("allDishes", allDishes);
//
//        return "menu";
//    }
//
//
//    @GetMapping("/menuoverview")
//    public String showMenuOverview(HttpSession session, Model model, Principal principal) {
//        List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");
//        model.addAttribute("selectedDishes", selectedDishes != null ? selectedDishes : new ArrayList<Dish>());
//
//
//        if (principal != null) {
//            Chef chef = chefRepository.findByUsername(principal.getName());
//            model.addAttribute("chefDishes", chef.getDishes());
//            model.addAttribute("count", chef.getDishes().size());
//            model.addAttribute("user", principal.getName());
//
//
//        } else {
//            model.addAttribute("chefDishes", new ArrayList<Dish>());
//            model.addAttribute("count", selectedDishes != null ? selectedDishes.size() : 0);
//            model.addAttribute("user", "Guest");
//        }
//
//
//        return "menuoverview";
//    }
//
//    @PostMapping("/dishes/select")
//    public String selectDishes(@RequestParam("selectedDishes") List<Integer> dishIds, HttpSession session, Principal principal) {
//        List<Dish> selectedDishes = new ArrayList<>();
//        for (Integer dishId : dishIds) {
//            Dish selectedDish = dishRepository.findById(dishId).orElse(null);
//            if (selectedDish != null) {
//                selectedDishes.add(selectedDish);
//            }
//        }
//
//        if (principal != null) {
//            Chef chef = chefRepository.findByUsername(principal.getName());
//            for (Dish dish : selectedDishes) {
//                chef.addDish(dish);
//            }
//            chefRepository.save(chef);
//        } else {
//            List<Dish> sessionDishes = (List<Dish>) session.getAttribute("selectedDishes");
//            if (sessionDishes == null) {
//                sessionDishes = new ArrayList<>();
//            }
//            sessionDishes.addAll(selectedDishes);
//            session.setAttribute("selectedDishes", sessionDishes);
//        }
//
//        return "redirect:/menuoverview";
//    }
//
//    @PostMapping("/dishdetails/{id}")
//    public String selectDish(Model model, @RequestParam("dishId") Integer dishId, HttpSession session, Principal principal) {
//        Chef chef = null;
//        if (principal != null) {
//            chef = chefRepository.findByUsername(principal.getName());
//        }
//
//        Dish selectedDish = dishRepository.findById(dishId).orElseThrow(() -> new IllegalStateException("Dish not found"));
//
//        if (chef != null) {
//            chef.addDish(selectedDish);
//            chefRepository.save(chef);
//            model.addAttribute("user", principal.getName());
//        } else {
//            List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");
//            if (selectedDishes == null) {
//                selectedDishes = new ArrayList<>();
//            }
//            selectedDishes.add(selectedDish);
//            session.setAttribute("selectedDishes", selectedDishes);
//            model.addAttribute("user", "Guest");
//        }
//
//        model.addAttribute("selectedDishChef", selectedDish);
//        model.addAttribute("dish", selectedDish);
//        return "redirect:/dishdetails/" + dishId;
//    }
//    @PostMapping("/menuoverview/delete/{dishId}")
//    public String deleteDish(@PathVariable("dishId") Integer dishId, HttpSession session, Principal principal) {
//        if (principal != null) {
//            Chef chef = chefRepository.findByUsername(principal.getName());
//            Dish dishToRemove = chef.getDishes().stream()
//                    .filter(dish -> dish.getId().equals(dishId))
//                    .findFirst()
//                    .orElse(null);
//
//            if (dishToRemove != null) {
//                chef.removeDish(dishToRemove);
//                chefRepository.save(chef);
//            }
//        } else {
//            List<Dish> selectedDishes = (List<Dish>) session.getAttribute("selectedDishes");
//            if (selectedDishes != null) {
//                selectedDishes.removeIf(dish -> dish.getId().equals(dishId));
//                session.setAttribute("selectedDishes", selectedDishes);
//            }
//        }
//
//        return "redirect:/menuoverview";
//    }
//
//

    @GetMapping("/menu/select/{id}")
    public String selectMenu(@PathVariable(required = false) Integer id, Model model, Principal principal) {

        Chef chef = chefRepository.findByUsername(principal.getName());
        Iterable<Menu> menusOfChef = menuRepository.findByChef(chef);

        if (chef == null) {
            return "redirect:/login";
        }

        if (menusOfChef == null) {
            return "redirect:/menu/add";
        }
        model.addAttribute("dishId", id);
        model.addAttribute("menus", menusOfChef);

        return "/menu/select";
    }

    @PostMapping("/menu/{menuId}/addDish/{dishId}")
    public String addDishToMenu(@PathVariable Integer menuId, @PathVariable Integer dishId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

        if (!menu.getDishes().contains(dish)) {
            menu.getDishes().add(dish);
            menuRepository.save(menu);
        }

        return "redirect:/menu/select/" + dishId;
    }

    @GetMapping("/menu/list")
    public String listMenus(Model model, Principal principal) {
        Iterable<Menu> menus = menuRepository.findAll();
        model.addAttribute("menus", menus);
        return "menu/list";

    }


    @PostMapping("/menu/create")
    public String createMenu(@RequestParam String menuName, Principal principal) {
        if (!principal.getName().isEmpty()) {
            Chef chef = chefRepository.findByUsername(principal.getName());
            if (chef != null) {
                Menu newMenu = new Menu();
                newMenu.setName(menuName);
                newMenu.setChef(chef);
                menuRepository.save(newMenu);
                return "redirect:/menu/list";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/menu/details/{id}")
public String menuDetails(@PathVariable("id") Integer id, Model model) {
    Menu menu = menuRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + id));
    model.addAttribute("menu", menu);
    return "menu/details";
}
}