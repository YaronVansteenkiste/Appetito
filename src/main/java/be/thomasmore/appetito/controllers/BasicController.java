package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.repositories.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @Autowired
    BasicRepository basicRepository;
    @GetMapping("/basic")
    public String basic(Model model){
        model.addAttribute("basics", basicRepository.findAll());
        model.addAttribute("count", basicRepository.count());
        return "basic";
    }
}
