package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Errandslist;
import be.thomasmore.appetito.model.Ingredient;
import be.thomasmore.appetito.repositories.ErrandsRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GroceriesController {

    @Autowired
    ErrandsRepository errandsRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/groceries")
    public String groceries(Model model, Errandslist errandslist){
        Iterable<Errandslist> allErrands = errandsRepository.findAll();
        Iterable<Ingredient> allIngredients = ingredientRepository.findAll();
        model.addAttribute("count",allErrands.spliterator().estimateSize());
        model.addAttribute("errands",errandslist);
        model.addAttribute("allErrands",allErrands);
        model.addAttribute("allIngredients",allIngredients);
        return "groceries";
    }
}
