package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Basic;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Technique;
import be.thomasmore.appetito.repositories.BasicRepository;
import be.thomasmore.appetito.repositories.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;



    @Controller
    public class BasicDtoController {

        @Autowired
        BasicRepository basicRepository;

        @Autowired
        TechniqueRepository techniqueRepository;

        @GetMapping({"/basicdetails/{id}", "/basicdetails"})
        public String basicDetails(Model model, @PathVariable(required = false) Integer id) {
            if (id == null) {
                return "error";
            }

            Optional<Basic> optionalBasic = basicRepository.findById(id);
            if (optionalBasic.isPresent()) {
                Basic basic = optionalBasic.get();
                model.addAttribute("basic", basic);
                Collection<Technique> techniques = basic.getTechniques();
                model.addAttribute("techniques", techniques);
                return "basicdetails";
            } else {
                return "error";
            }
        }
    }

