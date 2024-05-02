package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Errandslist;
import be.thomasmore.appetito.repositories.ErrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GroceriesController {

    @Autowired
    ErrandsRepository errandsRepository;

    @GetMapping("/groceries")
    public String groceries(Model model, Errandslist errandslist){
        Iterable<Errandslist> allErrands = errandsRepository.findAll();
        model.addAttribute("count",allErrands.spliterator().estimateSize());
        model.addAttribute("errands",errandslist);
        model.addAttribute("allErrands",allErrands);
        return "groceries";
    }
}
