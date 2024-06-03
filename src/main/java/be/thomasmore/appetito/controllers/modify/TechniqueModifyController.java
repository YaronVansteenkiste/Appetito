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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String showAddBasicForm(Model model, @PathVariable(required = false) Integer id) {
        Basic basic = (id != null) ? basicRepository.findById(id).orElse(new Basic()) : new Basic();
        model.addAttribute("basic", basic);
        model.addAttribute("id", id);
        return "/modify/addbasicaction";
    }

    @PostMapping({"/addbasicaction", "/addbasicaction/{id}"})
    public String addBasic(@ModelAttribute Basic basic, @PathVariable(required = false) Integer id,
                           @RequestParam(required = false) String action, @RequestParam(required = false) String description,
                           @RequestParam(required = false) List<MultipartFile> images) {
        basic.setAction(action);
        basic.setDescription(description);
//        if (images != null && !images.isEmpty()) {
//            String uploadedImages = images.stream().map(uploadImage(images)).collect(Collectors.toList());
//            basic.setImage(uploadedImages);
//        }
        if (id != null) {
            basic.setId(id);
        }
        basicRepository.save(basic);
        return "redirect:/modify/addtechnique/" + basic.getId();
    }


//    @GetMapping({"/addtechnique", "/addtechnique/{id}"})
//    public String showAddTechniqueForm(@PathVariable(required = false) Integer id, Model model) {
//        Technique technique;
//        if (id != null) {
//            // Fetching an existing technique if ID is provided
//            Optional<Technique> optionalTechnique = techniqueRepository.findById(id);
//            if (optionalTechnique.isPresent()) {
//                technique = optionalTechnique.get();
//                Iterable<Technique> techniques = techniqueRepository.findByTechniqueId(id);
//                TechniqueListWrapper wrapper = new TechniqueListWrapper();
//                wrapper.setTechniques((List<Technique>) techniques);
//
//                model.addAttribute("technique", technique);
//                model.addAttribute("techniqueListWrapper", wrapper);
//                return "modify/addtechnique";
//            } else {
//                // Redirect or handle the case where the technique is not found
//                return "redirect:/basic";
//            }
//        } else {
//            // Initialize a new Technique for adding
//            technique = new Technique();
//            model.addAttribute("technique", technique);
//            return "modify/addtechnique";
//        }
//    }

//    @GetMapping("/addtechnique/{id}")
//    public String showAddTechniquesForm(@PathVariable("id") Integer techniqueId, Model model, Principal principal, RedirectAttributes redirectAttributes) {
//        Optional<Basic> optionalBasic = basicRepository.findById(techniqueId);
//        if (optionalBasic.isPresent()) {
//            Basic basic = optionalBasic.get();
//            Iterable<Technique> techniques = techniqueRepository.findByTechniqueId(techniqueId);
//            TechniqueListWrapper wrapper = new TechniqueListWrapper();
//            wrapper.setTechniques((List<Technique>) techniques);
//
//            model.addAttribute("basic", basic);
//            model.addAttribute("techniqueListWrapper", wrapper);
//            return "modify/addtechnique" + techniqueId;
//        } else {
//            return "redirect:/basic";
//        }
//    }

    @GetMapping("/addtechnique/{basicActionId}")
    public String showAddTechniquesForm(@PathVariable("basicActionId") Integer basicActionId, Model model) {
        Technique technique = new Technique();  // Create a new, empty Technique instance
        technique.setBasicActionId(basicActionId);  // Assuming there's a field to link Technique to BasicAction

        model.addAttribute("technique", technique);  // Add to model for form binding

        TechniqueListWrapper wrapper = new TechniqueListWrapper();  // Optional: Only if needed to manage lists of techniques
        wrapper.setTechniques(new ArrayList<>());  // Initialize with an empty list if necessary
        model.addAttribute("techniqueListWrapper", wrapper);  // Optional: Add wrapper to the model if list management is needed

        model.addAttribute("basicActionId", basicActionId);  // Pass the ID to the view for reference

        return "modify/addtechnique";  // Return the view for adding a new technique
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

