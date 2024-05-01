package be.thomasmore.appetito.controllers.admin;


import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.DishDto;
import be.thomasmore.appetito.repositories.DishRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;


@RequestMapping("/admin")
@Controller
public class DishAdminController {

    @Autowired
    DishRepository dishRepository;

    @ModelAttribute("dish")
    public Dish findDish(@PathVariable(required = false) Integer id){
        if (id != null) {
            Optional<Dish> dishFromDB = dishRepository.findById(id);
            return dishFromDB.orElseGet(Dish::new);
        } else {
            return new Dish();
        }
    }


    @GetMapping("/dishedit/{id}")
    public String dishEdit(Model model, @PathVariable(required = false) Integer id){
        return "admin/dishedit";
    }

    @PostMapping("/dishedit/{id}")
    public String dishEditPost(@ModelAttribute("dish") Dish dish){
        dishRepository.save(dish);
        return "redirect:/dishdetails/" + dish.getId();
    }
    @GetMapping("/addmeal")
    public String showCreateDish(Model model) {
        DishDto dishDto = new DishDto();
        model.addAttribute("dishDto", dishDto);

        return "admin/addmeal";
    }

    @PostMapping("/addmeal")
    public String createDish(@Valid @ModelAttribute DishDto dishDto, BindingResult result) {

        Dish dish = new Dish();
        if (dishDto.getMultipartFile().isEmpty()) {
            result.addError(new FieldError("dishDto", "multipartFile", "Image file is required"));
        }

        dish.setName(dishDto.getName());
        dish.setDietPreferences(dishDto.getDietPreferences());
        dish.setOccasion(dishDto.getOccasion());
        dish.setPreparation(dishDto.getPreparation());

        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.util.Date parsedTime = timeFormat.parse(String.valueOf(dishDto.getPreparationTime()));
            Time preparationTime = new Time(parsedTime.getTime());
            dish.setPreparationTime(preparationTime);
        } catch (ParseException e) {
            result.addError(new FieldError("dishDto", "preparationTime", "Invalid time format"));
            return "admin/addmeal";
        }


        try {
            dish.setImgFileName(uploadImage(dishDto.getMultipartFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        dishRepository.save(dish);
        return "redirect:/dishes";
    }


    private String uploadImage(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        final String directoryPath = "src/main/resources/static/img/";
        File directory = new File(directoryPath.trim());
        if (!directory.exists()) {
            directory.mkdirs();
        }


        String filename = multipartFile.getOriginalFilename();
        Path path = Paths.get(directoryPath + filename);
        Files.copy(multipartFile.getInputStream(), path);

        return filename;
    }
}
