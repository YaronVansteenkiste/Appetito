package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Menu;
import be.thomasmore.appetito.model.MenuDay;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import be.thomasmore.appetito.repositories.MenuDayRepository;
import be.thomasmore.appetito.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class MenuController {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuDayRepository menuDayRepository;


    @PostMapping("/menu/{menuId}/addDay")
    public String addDayToMenu(@PathVariable Integer menuId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        MenuDay menuDay = new MenuDay();

        menuDay = menuDayRepository.save(menuDay);

        menuDay.setMenu(menu);
        menuDayRepository.save(menuDay);

        redirectAttributes.addFlashAttribute("success", "Day added to menu successfully");

        return "redirect:/menu/details/" + menuId;
    }


    @PostMapping("/menu/{menuId}/addDish/{dishId}")
    public String addDishToMenu(@PathVariable Integer menuId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes) {
        Optional<Menu> menu = Optional.ofNullable(menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId)));
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

        List<MenuDay> menuDays = menuDayRepository.findByMenu(menu);
        for (MenuDay menuDay : menuDays) {
            if (menuDay.getDishes().size() < 3) {
                menuDay.getDishes().add(dish);
                menuDayRepository.save(menuDay);
                redirectAttributes.addFlashAttribute("success", "Dish added to menu");
                return "redirect:/menu/details/" + menuId;
            }
        }

        redirectAttributes.addFlashAttribute("error", "Menu is full");
        return "redirect:/menu/details/" + menuId;
    }


    @PostMapping("/menu/{menuId}/selectDay/{dayId}/addDish/{dishId}")
public String addDishToDay(@PathVariable Integer menuId, @PathVariable Integer dayId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes) {
    Menu menu = menuRepository.findById(menuId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
    MenuDay menuDay = menuDayRepository.findById(dayId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid day Id:" + dayId));
    Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

    if (!menu.getMenuDays().contains(menuDay)) {
        throw new IllegalArgumentException("The selected day does not belong to the selected menu");
    }

    menuDay.getDishes().add(dish);
    menuDayRepository.save(menuDay);

    redirectAttributes.addFlashAttribute("success", "Dish added to day successfully");

    return "redirect:/menu/details/" + menuId;
}

    @PostMapping("/menu/delete/{menuId}")
    public String deactivateMenu(@PathVariable Integer menuId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        menu.setActive(false);
        menuRepository.save(menu);

        redirectAttributes.addFlashAttribute("success", "Menu is successfully deactivated");

        return "redirect:/menu/list";
    }

    @GetMapping("/menu/list")
    public String listMenus(Model model, Principal principal) {
        Iterable<Menu> menus = menuRepository.findAllByActiveTrue();
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
    public String getMenuDetails(@PathVariable("id") Integer id, Model model) {
        Optional<Menu> menu = menuRepository.findById(id);
        List<MenuDay> menuDays = menuDayRepository.findByMenu(menu);
        model.addAttribute("menu", menu.get());
        model.addAttribute("menuDays", menuDays);
        return "menu/details";
    }

    @GetMapping("/menu/select/{id}")
    public String selectMenu(@PathVariable(required = false) Integer id, Model model, Principal principal) {

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


        return "menu/select";
    }
}