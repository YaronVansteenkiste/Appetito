package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Basic;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasicDtoController {

    @Autowired
    BasicRepository basicRepository;

    @GetMapping({"/basicdetails/{id}", "/basicdetails"})
    private String basicDetails(Model model, @PathVariable(required = false) Integer id) {
        final Iterable<Basic> allBasics = basicRepository.findAll();
        model.addAttribute("basics", allBasics);
        return "basicdetails";
    }
}
