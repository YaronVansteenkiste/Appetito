package be.thomasmore.appetito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishesController {
    @GetMapping("/dishes")
    public String Home(Model model) {


        return "dishes";
    }


}