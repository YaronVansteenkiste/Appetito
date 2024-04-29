package be.thomasmore.appetito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishesController {

    @GetMapping("/dishes")
    public String dishes(Model model){
        return "dishes";
    }
}
