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

    @PostMapping("/menu/select/{menuId}/addDay/{dishId}")
    public String addSelectDay(@PathVariable Integer menuId,
                               @PathVariable Integer dishId,
                               RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.ofNullable(menu));

        if (menuDays.size() >= 7) {
            redirectAttributes.addFlashAttribute("error", "Er kunnen niet meer dan 7 dagen aan een menu worden toegevoegd.");
            return "redirect:/menu/details/" + menuId;
        }

        int nextDayNumber = menuDays.size() + 1;

        MenuDay newMenuDay = new MenuDay();
        newMenuDay.setDayNumber(nextDayNumber);
        newMenuDay.setMenu(menu);

        menuDayRepository.save(newMenuDay);

        redirectAttributes.addFlashAttribute("success", "Day added to menu successfully");

        return "redirect:/menu/select/" + dishId;
    }

@PostMapping("/menu/{menuId}/addDay")
public String addDay(@PathVariable Integer menuId, RedirectAttributes redirectAttributes) {
    Menu menu = menuRepository.findById(menuId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

    List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.ofNullable(menu));

    if (menuDays.size() >= 7) {
        redirectAttributes.addFlashAttribute("error", "Er kunnen niet meer dan 7 dagen aan een menu worden toegevoegd.");
        return "redirect:/menu/details/" + menuId;
    }

    int nextDayNumber = menuDays.size() + 1;

    MenuDay newMenuDay = new MenuDay();
    newMenuDay.setDayNumber(nextDayNumber);
    newMenuDay.setMenu(menu);

    menuDayRepository.save(newMenuDay);

    redirectAttributes.addFlashAttribute("success", "Dag succesvol toegevoegd aan het menu");

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

    if (!menuDay.getMenu().equals(menu)) {
        throw new IllegalArgumentException("De geselecteerde dag behoort niet tot het geselecteerde menu");
    }

    if (menuDay.getDishes().size() >= 5) {
        redirectAttributes.addFlashAttribute("error", "Niet meer dan 5 maaltijden per dag toegestaan.");
        return "redirect:/menu/select/" + dishId;
    }

    menuDay.getDishes().add(dish);
    menuDayRepository.save(menuDay);

    redirectAttributes.addFlashAttribute("success", dish.getName() + " toegevoegd aan dag "+menuDay.getDayNumber());

    return "redirect:/menu/select/" + dishId;
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