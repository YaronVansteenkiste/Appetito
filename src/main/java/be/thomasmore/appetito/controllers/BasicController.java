package be.thomasmore.appetito.controllers;

import be.thomasmore.appetito.model.Basic;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.repositories.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class BasicController {

    @Autowired
    BasicRepository basicRepository;

    private final Logger logger = Logger.getLogger(DishesController.class.getName());

    @GetMapping("/basic")
    public String basic(Model model){
        model.addAttribute("basics", basicRepository.findAll());
        model.addAttribute("count", basicRepository.count());
        return "basic";
    }

    @GetMapping("/basic/search")
    public String search(Model model, @RequestParam String keyword) {
        logger.info("searching for: " + keyword);
        List<String> keywords = Arrays.asList(keyword.split(",")).stream().map(String::trim).collect(Collectors.toList());
        Set<Basic> allBasics = new HashSet<>();
        for (String key : keywords) {
            Iterable<Basic> basics = basicRepository.findByActionOrTechniques(key);
            basics.forEach(allBasics::add);
        }
        model.addAttribute("count", allBasics.size());
        model.addAttribute("allbasics", allBasics);
        model.addAttribute("keyword", keyword);

        return "basic";
    }
}
