package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Grocery;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.GroceryRepository;
import be.thomasmore.appetito.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class GroceriesController {

    @Autowired
    GroceryRepository groceryRepository;

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ChefRepository chefRepository;

    private Logger logger = Logger.getLogger(GroceriesController.class.getName());

    @GetMapping({"/groceries/", "/groceries"})
    public String groceries(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        Chef chef = chefRepository.findByUsername(principal.getName());
        logger.info("Logged in chef: " + chef.getUsername());
        Integer chefId = chef.getId();

        Optional<Grocery> groceryFromDB = groceryRepository.findById(chefId);
        if (groceryFromDB.isPresent()) {
            Grocery grocery = groceryFromDB.get();
            logger.info("Fetched grocery: " + grocery.getId());
            model.addAttribute("grocery", grocery);
        } else {
            Grocery newGrocery = new Grocery();
            newGrocery.setChef(chef);
            Grocery savedGrocery = groceryRepository.save(newGrocery);
            model.addAttribute("grocery", savedGrocery);
        }

        return "groceries";
    }

    @DeleteMapping("/groceries/deleteIngredient/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Integer id, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Chef chef = chefRepository.findByUsername(principal.getName());
        Integer chefId = chef.getId();
        Optional<Grocery> groceryFromDB = groceryRepository.findById(chefId);
        if (groceryFromDB.isPresent()) {
            Grocery grocery = groceryFromDB.get();
            grocery.getIngredients().removeIf(ingredient -> ingredient.getId().equals(id));
            groceryRepository.save(grocery);
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("/groceries/clear")
    public ResponseEntity<?> clearAllGroceries(Principal principal) {
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Chef chef = chefRepository.findByUsername(principal.getName());
        Optional<Grocery> groceryFromDB = groceryRepository.findById(chefRepository.findByUsername(principal.getName()).getId());
        if (groceryFromDB.isPresent()) {
            Grocery grocery = groceryFromDB.get();
            grocery.getIngredients().clear();
            groceryRepository.save(grocery);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}