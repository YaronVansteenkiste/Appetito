package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.*;
import be.thomasmore.appetito.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/menu")
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
    @Autowired
    private GroceryRepository groceryRepository;

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @GetMapping("/details/{menuId}/ingredients")
    public String getMenuIngredients(@PathVariable Integer menuId, Model model, @PageableDefault(size = 10) Pageable pageable) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.ofNullable(menu));

        List<Ingredient> ingredients = new ArrayList<>();
        for (MenuDay menuDay : menuDays) {
            for (Dish dish : menuDay.getDishes()) {
                ingredients.addAll(dish.getIngredients());
            }
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), ingredients.size());
        Page<Ingredient> ingredientsPage = new PageImpl<>(ingredients.subList(start, end), pageable, ingredients.size());


        model.addAttribute("ingredients", ingredientsPage);
        model.addAttribute("menu", menu);
        return "menu/ingredients";
    }


    @PostMapping("/{menuId}/addToGrocery")
public String addMenuIngredientsToGrocery(@PathVariable Integer menuId, Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }

    Menu menu = menuRepository.findById(menuId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
    List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.ofNullable(menu));

    List<Ingredient> ingredients = new ArrayList<>();
    for (MenuDay menuDay : menuDays) {
        for (Dish dish : menuDay.getDishes()) {
            ingredients.addAll(dish.getIngredients());
        }
    }

        Chef chef = chefRepository.findByUsername(principal.getName());
        Optional<Grocery> groceryFromDB = groceryRepository.findById(chefRepository.findByUsername(principal.getName()).getId());

        if (groceryFromDB.isPresent()) {
            Grocery grocery = groceryFromDB.get();
            Collection<Ingredient> groceryIngredients = grocery.getIngredients();
            if (groceryIngredients == null) {
                groceryIngredients = new ArrayList<>();
            }
            logger.info("Grocery ingredients before addition: " + groceryIngredients.stream().map(i -> i.getName()).collect(Collectors.joining(", ")));
            for (Ingredient ingredient : ingredients) {
                if (!groceryIngredients.contains(ingredient)) {
                    groceryIngredients.add(ingredient);
                }
            }
            grocery.setIngredients(groceryIngredients);
            groceryRepository.save(grocery);
            logger.info("Grocery ingredients after addition: " + groceryIngredients.stream().map(i -> i.getName()).collect(Collectors.joining(", ")));

            Grocery savedGrocery = groceryRepository.findById(grocery.getId()).get();
            logger.info("Saved grocery ingredients: " + savedGrocery.getIngredients().stream().map(i -> i.getName()).collect(Collectors.joining(", ")));
        }

    return "redirect:/groceries";
}

    @PostMapping("/select/{menuId}/addDay/{dishId}")
    public String addSelectDay(@PathVariable Integer menuId,
                               @PathVariable Integer dishId,
                               RedirectAttributes redirectAttributes,
                               HttpServletRequest request) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.ofNullable(menu));

        if (menuDays.size() >= 7) {
            redirectAttributes.addFlashAttribute("error", "Er kunnen niet meer dan 7 dagen aan een menu worden toegevoegd.");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        int nextDayNumber = menuDays.size() + 1;

        MenuDay newMenuDay = new MenuDay();
        newMenuDay.setDayNumber(nextDayNumber);
        newMenuDay.setMenu(menu);

        menuDayRepository.save(newMenuDay);

        redirectAttributes.addFlashAttribute("success", "Day added to menu successfully");

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }


    @PostMapping("/{menuId}/removeDay/{dayId}")
    public String removeDayFromMenu(@PathVariable Integer menuId, @PathVariable Integer dayId, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        MenuDay menuDay = menuDayRepository.findById(dayId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid day Id:" + dayId));

        if (!menuDay.getMenu().equals(menu)) {
            throw new IllegalArgumentException("The selected day does not belong to the selected menu");
        }

        menuDayRepository.delete(menuDay);

        List<MenuDay> menuDays = menuDayRepository.findByMenu(Optional.of(menu));
        Collections.sort(menuDays, Comparator.comparing(MenuDay::getDayNumber));
        for (int i = 0; i < menuDays.size(); i++) {
            MenuDay day = menuDays.get(i);
            day.setDayNumber(i + 1);
            menuDayRepository.save(day);
        }

        redirectAttributes.addFlashAttribute("success", "Day " + menuDay.getDayNumber() + " removed from menu");

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/{menuId}/addDay")
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


    @PostMapping("/delete/{menuId}")
    public String deactivateMenu(@PathVariable Integer menuId, RedirectAttributes redirectAttributes) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));

        menu.setActive(false);
        menuRepository.save(menu);

        redirectAttributes.addFlashAttribute("success", "Menu is successfully deactivated");

        return "redirect:/menu/list";
    }

    @GetMapping("/list")
    public String listMenus(Model model, Principal principal) {
        Iterable<Menu> menus = menuRepository.findAllByActiveTrue();
        model.addAttribute("menus", menus);
        return "menu/list";
    }


    @PostMapping("/list")
    public String createMenu(@Valid Menu newMenu, BindingResult result, Model model, Principal principal) {
        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("menu", newMenu);
            return "menu/list";
        }

        if (!principal.getName().isEmpty()) {
            Chef chef = chefRepository.findByUsername(principal.getName());
            if (chef != null) {
                newMenu.setChef(chef);
                menuRepository.save(newMenu);
                return "redirect:/menu/list";
            }
        }
        return "redirect:/login";
    }


    @GetMapping("/details/{id}")
    public String getMenuDetails(@PathVariable("id") Integer id, Model model) {
        Optional<Menu> menu = menuRepository.findById(id);
        List<MenuDay> menuDays = menuDayRepository.findByMenu(menu);
        model.addAttribute("menu", menu.get());
        model.addAttribute("menuDays", menuDays);
        return "menu/details";
    }

    @GetMapping("/select/{id}")
    public String selectMenu(@PathVariable(required = false) Integer id, Model model, Principal principal) {

        Chef chef = chefRepository.findByUsername(principal.getName());
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + id));
        Iterable<Menu> menusOfChef = menuRepository.findByChef(chef);

        if (chef == null || dish == null) {
            return "redirect:/login";
        }

        model.addAttribute("dishId", id);
        model.addAttribute("menus", menusOfChef);
        model.addAttribute("dish", dish);

        return "menu/select";
    }

  @PostMapping("/select/{menuId}/addDish/{dishId}")
public String selectMenu(@PathVariable("menuId") Integer menuId, @PathVariable("dishId") Integer dishId) {
    return "redirect:/menu/addRemoveDishes/" + menuId + "/addDish/" + dishId;
}


    @GetMapping("/addRemoveDishes/{menuId}/addDish/{dishId}")
    public String addRemoveDishes(@PathVariable Integer menuId, @PathVariable Integer dishId, Model model) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

        model.addAttribute("menu", menu);
        model.addAttribute("dish", dish);
        return "menu/addRemoveDishes";
    }


@PostMapping("/{menuId}/selectDay/{dayId}/removeDish/{dishId}")
public String removeDishFromDay(@PathVariable Integer menuId, @PathVariable Integer dayId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes, HttpServletRequest request) {
    Menu menu = menuRepository.findById(menuId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + menuId));
    MenuDay menuDay = menuDayRepository.findById(dayId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid day Id:" + dayId));
    Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + dishId));

    if (!menuDay.getMenu().equals(menu)) {
        throw new IllegalArgumentException("The selected day does not belong to the selected menu");
    }

    menuDay.getDishes().remove(dish);
    menuDayRepository.save(menuDay);

    redirectAttributes.addFlashAttribute("success", dish.getName() + " removed from day " + menuDay.getDayNumber());

    String referer = request.getHeader("Referer");
    return "redirect:" + referer;
}


    @PostMapping("/{menuId}/selectDay/{dayId}/addDish/{dishId}")
    public String addDishToDay(@PathVariable Integer menuId, @PathVariable Integer dayId, @PathVariable Integer dishId, RedirectAttributes redirectAttributes, HttpServletRequest request) {
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
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        menuDay.getDishes().add(dish);
        menuDayRepository.save(menuDay);

        redirectAttributes.addFlashAttribute("success", dish.getName() + " toegevoegd aan dag " + menuDay.getDayNumber());

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }


    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") Integer id, Model model) {
        Optional<Menu> menu = menuRepository.getMenuById(id);
        model.addAttribute("menu", menu.get());
        return "menu/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMenu(@PathVariable("id") Integer id, @RequestParam("name") String name,
                             @RequestParam("numberOfPeople") int numberOfPeople, @RequestParam("description") String description) {
        Optional<Menu> menuFromDb = menuRepository.getMenuById(id);
        if (!menuFromDb.isPresent()) {
            return "redirect:/menu/list";
        }
        Menu menu = menuFromDb.get();
        menu.setNumberOfPeople(numberOfPeople);
        menu.setDescription(description);
        menu.setName(name);
        menuRepository.save(menu);
        return "redirect:/menu/details/" + id;
    }
}