package be.thomasmore.appetito.controllers.modify;


import be.thomasmore.appetito.model.*;
import be.thomasmore.appetito.repositories.BasicRepository;
import be.thomasmore.appetito.repositories.TechniqueRepository;
import be.thomasmore.appetito.services.GoogleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
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


    @GetMapping({"/addbasicaction", "/addbasicaction/{id}"})
    public String showAddBasicForm(@ModelAttribute Basic basic, Model model, @PathVariable(required = false) Integer id) {
        model.addAttribute("basic", new Basic());
        model.addAttribute("id", id);
        return "/modify/addbasicaction";
    }

    @PostMapping({"/addbasicaction", "/addbasicaction/{id}"})
    public String addBasic(@ModelAttribute Basic basic, @PathVariable(required = false) Integer id,
                           @RequestParam(required = false) String action,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) List<MultipartFile> image) throws IOException {
        basic.setAction(action);
        basic.setDescription(description);
        if (image != null && !image.isEmpty()) {
            basic.setImage(uploadImage((MultipartFile) image));
        }
        basicRepository.save(basic);
        return "redirect:/modify/addtechnique/" + id;
    }

    @GetMapping({"/addtechnique", "addtechnique/{id}"})
    public String showAddTechniqueForm(@PathVariable() Integer id, Model model) {
        Optional<Technique> optionalTechnique = techniqueRepository.findById(id);
        if (optionalTechnique.isPresent()) {
            Technique technique = optionalTechnique.get();
            Iterable<Technique> techniques = techniqueRepository.findByTechniqueId(id);
            TechniqueListWrapper wrapper = new TechniqueListWrapper();
            wrapper.setTechniques((List<Technique>) techniques);

            model.addAttribute("technique", technique);
            model.addAttribute("techniqueListWrapper", wrapper);

            return "modify/addtechnique" + id;
        } else {
            return "redirect:/basic";
        }
    }




    @GetMapping("/editbasicaction/{id}")
    public String basicEdit(Model model, @PathVariable(required = false) Integer id) {
        Optional<Basic> basicOptional = basicRepository.findById(id);

        if (basicOptional.isPresent()) {
            Basic basic = basicOptional.get();
            basic.setAction(basic.getAction());
            basic.setDescription(basic.getDescription());
            basic.setImage(basic.getImage());
            basic.setTechniques(basic.getTechniques());
            model.addAttribute("basic", basic);
            return "modify/editbasicaction";
        } else {
            return "redirect:/basic";
        }
    }




    private String uploadImage(MultipartFile multipartFile) throws IOException {
        final String filename = multipartFile.getOriginalFilename();
        final File fileToUpload = new File(filename);
        FileOutputStream fos = new FileOutputStream(fileToUpload);
        fos.write(multipartFile.getBytes());
        final String urlInFirebase = googleService.toFirebase(fileToUpload, filename);
        fileToUpload.delete();
        return urlInFirebase;
    }
    }
