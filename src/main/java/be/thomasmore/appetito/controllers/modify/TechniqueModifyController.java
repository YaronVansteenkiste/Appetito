package be.thomasmore.appetito.controllers.modify;


import be.thomasmore.appetito.model.*;
import be.thomasmore.appetito.repositories.BasicRepository;
import be.thomasmore.appetito.repositories.ChefRepository;
import be.thomasmore.appetito.repositories.TechniqueRepository;
import be.thomasmore.appetito.services.GoogleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@RequestMapping("/modify")
@Controller
public class TechniqueModifyController {

    private static final Logger logger = LoggerFactory.getLogger(TechniqueModifyController.class);

    @Autowired
    BasicRepository basicRepository;

    @Autowired
    GoogleService googleService;

    @Autowired
    TechniqueRepository techniqueRepository;

    @Autowired
    ChefRepository chefRepository;

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
        return "modify/addbasicaction";
    }

    @PostMapping({"/addbasicaction", "/addbasicaction/{id}"})
    public String addBasic(@ModelAttribute Basic basic, @PathVariable(required = false) Integer id,
                           @RequestParam(required = false) String action, @RequestParam(required = false) String description,
                           @RequestParam(required = false) List<MultipartFile> images) throws IOException {
        basic.setAction(action);
        basic.setDescription(description);
        if (!basic.getImage().isEmpty()) {
            basic.setImgFileName(uploadImage(basic.getImage()));
        }
        if (id != null) {
            basic.setId(id);
        }
        basicRepository.save(basic);
        return "redirect:/modify/addtechnique/" + basic.getId();
    }


    @GetMapping("/addtechnique/{basicActionId}")
    public String showAddTechniquesForm(@PathVariable("basicActionId") Integer basicActionId, Principal principal, Model model, RedirectAttributes redirectAttributes) throws IOException {
        Optional<Basic> optionalBasic = basicRepository.findById(basicActionId);
        if (optionalBasic.isPresent()) {
            Basic basic = optionalBasic.get();
            Iterable<Technique> techniques = techniqueRepository.findByBasicId(basicActionId);
            TechniqueListWrapper wrapper = new TechniqueListWrapper();
            wrapper.setTechniques((List<Technique>) techniques);

            model.addAttribute("basic", basic);
            model.addAttribute("techniqueListWrapper", wrapper);
            if (principal != null && principal.getName() != null){
                String username = principal.getName();
                Chef chef = chefRepository.findByUsername(username);
                model.addAttribute("chef", chef);

            }
            return "modify/addtechnique";
        } else {
            return "redirect:/basic/";
        }
    }


    @PostMapping("/addtechnique/{basicActionId}")
    @Transactional
    public String addTechnique(@PathVariable("basicActionId") Integer basicActionId,
                               @ModelAttribute("techniqueListWrapper") TechniqueListWrapper wrapper, Principal principal,
                               Model model) throws IOException {
        List<Technique> currentTechniques = wrapper.getTechniques();
        Optional<Basic> optionalBasic = basicRepository.findById(basicActionId);
        model.addAttribute("basic", optionalBasic.get());
        if (currentTechniques == null || currentTechniques.isEmpty()) {
            String userName = principal.getName();
            Chef chef = chefRepository.findByUsername(userName);
            model.addAttribute("chef", chef);
            model.addAttribute("error", "Er moet minimaal één techniek worden toegevoegd.");
            return "modify/addtechnique";
        }

        for (Technique technique : currentTechniques) {
            MultipartFile imageFile = technique.getImageFile();
            if (technique.getId() == null) {
                Technique newTechnique = new Technique();

                Optional<Basic> basicOptional = basicRepository.findById(basicActionId);
                newTechnique.setName(technique.getName());
                newTechnique.setBasic(basicOptional.get());
                newTechnique.setTechniqueDescription(technique.getTechniqueDescription());
                if (imageFile != null && !imageFile.isEmpty()) {
                    newTechnique.setImgFileName(uploadImage(imageFile));
                }
                techniqueRepository.save(newTechnique);
            } else {
                Optional<Technique> optionalTechnique = techniqueRepository.findById(technique.getId());
                if (optionalTechnique.isPresent()) {
                    Technique existingTechnique = optionalTechnique.get();
                    existingTechnique.setBasic(basicRepository.findById(basicActionId).get());
                    existingTechnique.setTechniqueDescription(technique.getTechniqueDescription());
                    if (imageFile != null && !imageFile.isEmpty()) {
                        existingTechnique.setImgFileName(uploadImage(imageFile));
                    }
                    techniqueRepository.save(existingTechnique);
                }
            }
        }
        return "redirect:/basic";
    }


    @DeleteMapping("/technique/{id}")
    public ResponseEntity<Void> deleteTechnique(@PathVariable Integer id) {
        Optional<Technique> optionalTechnique = techniqueRepository.findById(id);
        if (optionalTechnique.isPresent()) {
            techniqueRepository.delete(optionalTechnique.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
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

    @GetMapping("/edittechnique/{basicActionId}")
    public String editTechnique(@PathVariable("basicActionId") Integer basicActionId, Principal principal, Model model, RedirectAttributes redirectAttributes) throws IOException {
        Optional<Basic> optionalBasic = basicRepository.findById(basicActionId);
        if (optionalBasic.isPresent()) {
            Basic basic = optionalBasic.get();
            Iterable<Technique> techniques = techniqueRepository.findByBasicId(basicActionId);
            TechniqueListWrapper wrapper = new TechniqueListWrapper();
            wrapper.setTechniques((List<Technique>) techniques);

            model.addAttribute("basic", basic);
            model.addAttribute("techniqueListWrapper", wrapper);
            if (principal != null && principal.getName() != null){
                String username = principal.getName();
                Chef chef = chefRepository.findByUsername(username);
                model.addAttribute("chef", chef);

            }
            return "modify/edittechnique";
        } else {
            return "redirect:/basic/";
        }
    }

    @PostMapping("/edittechnique/{basicActionId}")
    @Transactional
    public String editTechnique(@PathVariable("basicActionId") Integer basicActionId,
                               @ModelAttribute("techniqueListWrapper") TechniqueListWrapper wrapper, Principal principal,
                               Model model) throws IOException {
        List<Technique> currentTechniques = wrapper.getTechniques();
        Optional<Basic> optionalBasic = basicRepository.findById(basicActionId);
        model.addAttribute("basic", optionalBasic.get());
        if (currentTechniques == null || currentTechniques.isEmpty()) {
            String userName = principal.getName();
            Chef chef = chefRepository.findByUsername(userName);
            model.addAttribute("chef", chef);
            model.addAttribute("error", "Er moet minimaal één techniek worden toegevoegd.");
            return "modify/edittechnique";
        }

        for (Technique technique : currentTechniques) {
            MultipartFile imageFile = technique.getImageFile();
            if (technique.getId() == null) {
                Technique newTechnique = new Technique();

                Optional<Basic> basicOptional = basicRepository.findById(basicActionId);
                newTechnique.setName(technique.getName());
                newTechnique.setBasic(basicOptional.get());
                newTechnique.setTechniqueDescription(technique.getTechniqueDescription());
                if (imageFile != null && !imageFile.isEmpty()) {
                    newTechnique.setImgFileName(uploadImage(imageFile));
                }
                techniqueRepository.save(newTechnique);
            } else {
                Optional<Technique> optionalTechnique = techniqueRepository.findById(technique.getId());
                if (optionalTechnique.isPresent()) {
                    Technique existingTechnique = optionalTechnique.get();
                    existingTechnique.setBasic(basicRepository.findById(basicActionId).get());
                    existingTechnique.setName(technique.getName());
                    existingTechnique.setTechniqueDescription(technique.getTechniqueDescription());
                    if (imageFile != null && !imageFile.isEmpty()) {
                        existingTechnique.setImgFileName(uploadImage(imageFile));
                    }
                    techniqueRepository.save(existingTechnique);
                }
            }
        }
        return "redirect:/basic";
    }

    @PostMapping("/editbasicaction/{id}")
    public String basicActionPost(@Valid @ModelAttribute Basic basic, BindingResult result,
                               @RequestParam(required = false) MultipartFile image,
                               @PathVariable int id, Model model) {

        if (result.hasErrors()) {
            logger.error("validation errors: {}", result.getAllErrors());

            model.addAttribute("Basic", basic);
            return "modify/editbasicaction";
        }

        try {
            Optional<Basic> optionalBasic = basicRepository.findById(id);

            if (optionalBasic.isPresent()) {
                Basic basicFromDB = optionalBasic.get();
                basicFromDB.setAction(basic.getAction());
                basicFromDB.setDescription(basic.getDescription());
                if (image != null && !image.isEmpty()) {
                    basicFromDB.setImgFileName(uploadImage(image));
                }
                basicRepository.save(basicFromDB);

                return "redirect:/modify/edittechnique/" + id;
            }
        } catch (Exception ex) {
            logger.error("Error: {}", ex.getMessage());
        }
        return "redirect:/modify/edittechnique/" + id;
    }

    private String uploadImage(MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            final String filename = multipartFile.getOriginalFilename();
            final File fileToUpload = new File(filename);
            FileOutputStream fos = new FileOutputStream(fileToUpload);
            fos.write(multipartFile.getBytes());
            final String urlInFirebase = googleService.toFirebase(fileToUpload, filename);
            fileToUpload.delete();
            return urlInFirebase;
        }
        return null;
    }
}

