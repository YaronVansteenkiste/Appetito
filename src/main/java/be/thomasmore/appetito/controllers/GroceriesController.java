package be.thomasmore.appetito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroceriesController {

    @GetMapping("/groceries")
    public String groceries(Model model){
        return "groceries";
    }
}