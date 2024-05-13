package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Grocery;
import be.thomasmore.appetito.model.Ingredient;
import be.thomasmore.appetito.repositories.ErrandsRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class GroceriesController {

    @Autowired
    ErrandsRepository errandsRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/groceries/{id}")
    public String groceries(Model model, @PathVariable(required = false) Integer id) {
        Optional<Grocery> groceryFromDB = errandsRepository.findById(id);
        groceryFromDB.ifPresent(grocery -> {
            model.addAttribute("grocery", grocery);
        });

        return "groceries";
    }
}
