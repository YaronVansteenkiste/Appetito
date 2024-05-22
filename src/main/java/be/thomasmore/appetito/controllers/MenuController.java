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
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class MenuController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ChefRepository chefRepository;
    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/menu/select/{id}")
    public String selectMenu(@PathVariable(required = false) Integer id, Model model, Principal principal, RedirectAttributes redirectAttributes) {

        Chef chef = chefRepository.findByUsername(principal.getName());
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + id));
        Iterable<Menu> menusOfChef = menuRepository.findByChef(chef);

        if (chef == null) {
            return "redirect:/login";
        }

        model.addAttribute("dishId", id);
        model.addAttribute("menus", menusOfChef);
        model.addAttribute("dish", dish);


        return "/menu/select";
    }

    @PostMapping("/menu/{menuId}/removeDish/{dishId}")
    public String removeDishFromMenu(@PathVariable Integer menuId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

        if (menu.getDishes().contains(dish)) {
            menu.getDishes().remove(dish);
            menuRepository.save(menu);
            redirectAttributes.addFlashAttribute("success", dish.getName() + " is removed from " + menu.getName());
        } else {
            redirectAttributes.addFlashAttribute("warning", dish.getName() + " is not in " + menu.getName());
        }

        return "redirect:/menu/details/" + menuId;
    }

    @PostMapping("/menu/{menuId}/addDish/{dishId}")
    public String addDishToMenu(@PathVariable Integer menuId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

        if (menu.getDishes().contains(dish)) {
            redirectAttributes.addFlashAttribute("warning", dish.getName() + " is al toegevoegd aan " + menu.getName());
        } else {
            menu.getDishes().add(dish);
            menuRepository.save(menu);
            redirectAttributes.addFlashAttribute("success", dish.getName() + " is toegevoegd aan " + menu.getName());
        }

        return "redirect:/menu/select/" + dishId;
    }

    @PostMapping("/menu/delete/{menuId}")
    public String deleteMenu(@PathVariable Integer menuId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        menu.getDishes().clear();
        menuRepository.save(menu);

        menuRepository.delete(menu);
        redirectAttributes.addFlashAttribute("success", "Menu is successfully deleted");

        return "redirect:/menu/list";
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