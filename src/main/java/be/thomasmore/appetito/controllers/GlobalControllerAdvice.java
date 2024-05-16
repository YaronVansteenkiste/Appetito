package be.thomasmore.appetito.controllers;


import be.thomasmore.appetito.model.Footer;
import be.thomasmore.appetito.repositories.FooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private FooterRepository footerRepository;

    public GlobalControllerAdvice(FooterRepository footerRepository) {
        this.footerRepository = footerRepository;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        Optional<Footer> footer = footerRepository.findById(1);
        footer.ifPresent(value -> model.addAttribute("footer", value));
    }
}
