package be.thomasmore.appetito.controllers.modify;


import be.thomasmore.appetito.model.Basic;
import be.thomasmore.appetito.model.Technique;
import be.thomasmore.appetito.repositories.BasicRepository;
import be.thomasmore.appetito.repositories.TechniqueRepository;
import be.thomasmore.appetito.services.GoogleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping ("/modify")
@Controller
public class TechniqueModifyController {

    private static final Logger logger = LoggerFactory.getLogger(TechniqueModifyController.class);

    @Autowired
    BasicRepository basicRepository;

    @Autowired
    GoogleService googleService;

    @Autowired
    TechniqueRepository techniqueRepository;

    @ModelAttribute("technique")
    public Technique findTechnique(@PathVariable(required = false) Integer id) {
        if (id != null) {
            Optional<Technique> techniqueFromDB = techniqueRepository.findById(id);
            return techniqueFromDB.orElseGet(Technique::new);
        } else {
            return new Technique();
        }
    }



        @GetMapping("/addbasicaction")
        public String showAddBasicForm(@ModelAttribute Basic basic, Model model) {
            model.addAttribute("basic", new Basic());
            return "/modify/addbasicaction";
        }

        @PostMapping("/addbasicaction")
        public String addBasic(@ModelAttribute Basic basic, @RequestParam(required = false) Integer id,
                                   @RequestParam(required = false) String action,
                                   @RequestParam(required = false) String description,
                                   @RequestParam(required = false) String image) {
        basic.setAction(action);
        basic.setDescription(description);
        basic.setImage(image);
        basicRepository.save(basic);
        return "redirect:/basic";
        }
    }

