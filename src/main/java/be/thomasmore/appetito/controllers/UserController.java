package be.thomasmore.appetito.controllers;


import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.DishRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    DishRepository dishRepository;

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        if (principal != null) return "redirect:/";
        return "user/login";
    }


    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/";
        return "user/register";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails userDetails, @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "10") int size) {


        if (userDetails == null) {
            return "redirect:/";
        }
        int pagesize = size;
        Pageable pageable = PageRequest.of(page, pagesize);
        Page<Dish> dishesPage = chefRepository.findProductsPageable(10, pageable);
        long totalDishes = dishesPage.getTotalElements();
        int totalPages = dishesPage.getTotalPages();



        Chef chef = chefRepository.findByUsernameWithDishes(userDetails.getUsername());
        if (chef == null) {
            return "redirect:/";
        }
        long ConceptDishesCount = chef.getDishes().stream().filter(Dish::isConceptDish).count();
        List<Dish> allDishes = dishRepository.findByChefAndConceptDish(chef);
        List<Dish> favoriteDishes = chefRepository.getFavoriteDishesByChefId(chef.getId());
        model.addAttribute("chef", chef);
        model.addAttribute("allDishes", allDishes);
        model.addAttribute("favoriteDishes", favoriteDishes);
        model.addAttribute("ConceptDishesCount", ConceptDishesCount);

        return "user/profile";
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        if (principal == null) return "redirect:/";
        return "user/logout";
    }


    @PostMapping("/register")
    public String registerPost(Principal principal,
                               HttpServletRequest request,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String surname) throws ServletException {
        if (principal != null) return "redirect:/";
        if (username == null || username.isBlank()) return "redirect:/";
        if (jdbcUserDetailsManager.userExists(username)) return "redirect:/";

        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
        jdbcUserDetailsManager.createUser(user);

        Chef chef = new Chef();
        chef.setName(name);
        chef.setUsername(username);
        chef.setEmail(email);
        chef.setSurname(surname);
        chefRepository.save(chef);

        request.login(username, password);

        return "redirect:/";
    }

}
