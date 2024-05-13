package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Grocery;
import be.thomasmore.appetito.model.Ingredient;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.ErrandsRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class GroceriesController {

    @Autowired
    ErrandsRepository errandsRepository;

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ChefRepository chefRepository;

    private Logger logger = Logger.getLogger(GroceriesController.class.getName());

    @GetMapping("/groceries/")
    public String groceries(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Chef chef = chefRepository.findByUsername(principal.getName());
        logger.info("Chef: " + chef.getName());
        Integer chefId = chef.getId();

        Optional<Grocery> groceryFromDB = errandsRepository.findById(chefId);
        groceryFromDB.ifPresent(grocery -> {
            model.addAttribute("grocery", grocery);
        });

        return "groceries";
    }
}
